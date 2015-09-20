package astview;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class Driver {
	public static String PATH;

	private static List<String> filepaths;
	private static Iterator<String> iter;

	public static CompilationUnit getCompilationUnit(String javaFilePath) {
		byte[] input = null;
		try {
			BufferedInputStream bufferedInputStream = new BufferedInputStream(
					new FileInputStream(javaFilePath));
			input = new byte[bufferedInputStream.available()];
			bufferedInputStream.read(input);
			bufferedInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		@SuppressWarnings("deprecation")
		ASTParser astParser = ASTParser.newParser(AST.JLS3);
		astParser.setSource(new String(input).toCharArray());
		astParser.setKind(ASTParser.K_COMPILATION_UNIT);

		CompilationUnit result = (CompilationUnit) (astParser.createAST(null));

		return result;
	}

	public static void main(String args[]) {
		PathExplorer explorer = PathExplorer.startExplore("src\\testcase\\");
		filepaths = explorer.getFilePaths();
		iter = filepaths.iterator();
		while (iter.hasNext()) {
			PATH = iter.next();
			System.out.println(PATH);
			CompilationUnit result = getCompilationUnit(PATH);
			ASTViewContentProvider view = new ASTViewContentProvider();
			ASTViewContentProvider.isPrint=false;
			view.getChildren(result);
		}
	}
}

class PathExplorer {

	private List<String> filePaths = new ArrayList<String>();
	private List<String> srcs = new ArrayList<String>();
	private List<String> bins = new ArrayList<String>();

	public static PathExplorer startExplore(String dirPath) {
		return new PathExplorer(dirPath);
	}

	private PathExplorer(String dirPath) {
		readDirectory(dirPath);
	}

	// recursively read all files under dirPath
	private void readDirectory(String dirPath) {

		File dir = new File(dirPath);

		if (!dir.exists()) {
			throw new IllegalStateException("Illegal Directory Path: "
					+ dir.getAbsolutePath());
		}

		for (File subdir : dir.listFiles()) {
			if (subdir.isDirectory()) {
				if (subdir.getName().trim().equals("bin")) {
					bins.add(subdir.getAbsolutePath());
				} else if (subdir.getName().startsWith("src")) {
					srcs.add(subdir.getAbsolutePath());
				}
				// recursively read subdirectories except bin/
				if (!subdir.getName().startsWith("bin")) {
					readDirectory(subdir.getPath());
				}
			} else {
				if (subdir.getName().endsWith(".java")) {
					filePaths.add(subdir.getAbsolutePath());
				} else if (subdir.getName().endsWith(".jar")) {
					bins.add(subdir.getAbsolutePath());
				}
			}
		}
	}

	public List<String> getFilePaths() {
		return filePaths;
	}

	public String[] getSourcePaths() {
		return srcs.toArray(new String[srcs.size()]);
	}

	public String[] getClassPaths() {
		return bins.toArray(new String[bins.size()]);
	}
}
