package com.accesstage.hikeremissaocomprovcarga.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;

public class FileUtil {
	private String charset = "ISO-8859-1";
	private FileInputStream ifs;
	private InputStreamReader isr;
	private BufferedReader ibr;
	private File ifile;
	private FileOutputStream ofs;
	private OutputStreamWriter osw;
	private BufferedWriter obw;
	private File ofile;
	private boolean endOfLine;

	public FileUtil() {
		this.ifs = null;
		this.isr = null;
		this.ibr = null;
		this.ifile = null;

		this.ofs = null;
		this.osw = null;
		this.obw = null;
		this.ofile = null;
	}

	public boolean isEndOfLine() {
		return this.endOfLine;
	}

	public void setEndOfLine(boolean endOfLine) {
		this.endOfLine = endOfLine;
	}

	public File getFileIn() {
		return this.ifile;
	}

	public File getFileOut() {
		return this.ofile;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getCharset() {
		return this.charset;
	}

	public void setFileIn(String file) throws Exception {
		setFileIn(new File(file));
	}

	public void setFileIn(File file) throws Exception {
		if ((file == null) || (!file.exists()) || (!file.isFile())) {
			throw new Exception("O arquivo IN "
					+ (file != null ? file.getAbsolutePath() : "")
					+ " nao e um arquivo valido");
		}
		this.ifile = file;
		this.ifs = new FileInputStream(this.ifile);
		this.isr = new InputStreamReader(this.ifs, this.charset);
		this.ibr = new BufferedReader(this.isr);
	}

	public String readLine() throws Exception {
		if (this.ibr == null)
			throw new Exception("FileUtil: O BufferReader esta nulo");

		return this.ibr.readLine();
	}

	public void setFileOut(String file) throws Exception {
		setFileOut(new File(file), false);
	}

	public void setFileOut(String file, boolean append) throws Exception {
		setFileOut(new File(file), append);
	}

	public void setFileOut(String file, String ext, String tempPath)
			throws Exception {
		setFileOut(file, ext, new File(tempPath));
	}

	public void setFileOut(String file, String ext, File tempPath) throws Exception {
		if ((tempPath == null) || (!tempPath.exists()) || (!tempPath.isDirectory())) {
			throw new Exception("O diretorio temporario " + tempPath.getAbsolutePath() + " nao e valido");
		}
		
		setFileOut(File.createTempFile(file, ext, tempPath));
	}

	public void setFileOut(File file) throws Exception {
		setFileOut(file, false);
	}

	public void setFileOut(File file, boolean append) throws Exception {
		this.ofile = file;
		this.ofs = new FileOutputStream(this.ofile, append);
		this.osw = new OutputStreamWriter(this.ofs, this.charset);
		this.obw = new BufferedWriter(this.osw);
	}

	public void write(String line) throws Exception {
		write(line, this.endOfLine);
	}
	
	public void write(String line, File file) throws Exception {
		write(line, this.endOfLine, file);
	}

	public void flush() throws Exception {
		if (this.obw == null)
			return;
		this.obw.flush();
	}

	public void write(String line, boolean eol, File file) throws Exception {
		setFileOut(file);
		eol = true;
		if (this.obw == null){
			throw new Exception("FileUtil: O BufferWriter esta nulo");
		}
		
		System.out.println("eol" +  eol);
		if (eol){
			line = line + "\r\n";
		}

		this.obw.write(line);
	}
	
	public void write(String line, boolean eol) throws Exception {
		if (this.obw == null){
			throw new Exception("FileUtil: O BufferWriter esta nulo");
		}
		
		if (eol)
			line = line + "\r\n";

		this.obw.write(line);
	}

	public void close() throws Exception {
		closeIn();
		closeOut();
	}

	public void closeIn() throws Exception {
		if (this.ibr != null) {
			this.ibr.close();
			this.ibr = null;
		}
		if (this.isr != null) {
			this.isr.close();
			this.isr = null;
		}
		if (this.ifs != null) {
			this.ifs.close();
			this.ifs = null;
		}
	}

	public void closeOut() throws Exception {
		if (this.obw != null) {
			this.obw.close();
			this.obw = null;
		}
		if (this.osw != null) {
			this.osw.close();
			this.osw = null;
		}
		if (this.ofs != null) {
			this.ofs.close();
			this.ofs = null;
		}
	}

	/*
	 * public int eolLength(String fileName) throws Exception { FileInputStream
	 * fs = null; InputStreamReader fr = null; BufferedReader br = null;
	 * 
	 * FileReader fileReader = null; try { fs = new FileInputStream(new
	 * File(fileName)); fr = new InputStreamReader(fs, this.charset); br = new
	 * BufferedReader(fr);
	 * 
	 * String line = null;
	 * 
	 * if ((line = br.readLine()) != null) { int lenLine = 0;
	 * 
	 * if (!Valida.isEmpty(line)) lenLine = line.length();
	 * 
	 * fileReader = new FileReader(fileName);
	 * 
	 * char[] eol = new char[lenLine + 5]; fileReader.read(eol);
	 * 
	 * String linAux = new String(eol); if ((linAux.indexOf("\r\n") != -1) ||
	 * (linAux.indexOf("\n\r") != -1)) return 2; String linAux; char[] eol; int
	 * lenLine; String line; return 1; } String line; return 0; } catch
	 * (Exception e) { throw e; } finally { if (br != null) { br.close(); br =
	 * null; } if (fr != null) { fr.close(); fr = null; } if (fs != null) {
	 * fs.close(); fs = null; } if (fileReader != null) { fileReader.close();
	 * fileReader = null; } } }
	 */

	public void copyFile(File in, File out) throws Exception {
		FileChannel sourceChannel = new FileInputStream(in).getChannel();
		FileChannel destinationChannel = new FileOutputStream(out).getChannel();
		sourceChannel.transferTo(0L, sourceChannel.size(), destinationChannel);
		sourceChannel.close();
		destinationChannel.close();
	}

	/*
	 * public void updateFileOut(ArrayList marks) throws Exception { if
	 * ((this.ofile == null) || (!this.ofile.exists()) ||
	 * (!this.ofile.isFile())) { throw new Exception("O arquivo OUT " +
	 * (this.ofile != null ? this.ofile.getAbsolutePath() : "") +
	 * " nao e um arquivo valido"); } if ((this.obw != null) || (this.osw !=
	 * null) || (this.ofs != null)) { throw new Exception("O arquivo OUT " +
	 * this.ofile.getAbsolutePath() +
	 * " esta aberto para gravacao. Feche o arquivo antes de executar o update (closeOut())"
	 * ); } updateFile(this.ofile.getAbsolutePath(), marks); }
	 * 
	 * public void updateFileIn(ArrayList marks) throws Exception { if
	 * ((this.ifile == null) || (!this.ifile.exists()) ||
	 * (!this.ifile.isFile())) { throw new Exception("O arquivo IN " +
	 * (this.ifile != null ? this.ifile.getAbsolutePath() : "") +
	 * " nao e um arquivo valido"); } if ((this.ibr != null) || (this.isr !=
	 * null) || (this.ifs != null)) { throw new Exception("O arquivo IN " +
	 * this.ifile.getAbsolutePath() +
	 * " esta aberto para leitura. Feche o arquivo antes de executar o update (closeIn())"
	 * ); } updateFile(this.ofile.getAbsolutePath(), marks); }
	 * 
	 * /*public void updateFile(String file, ArrayList marks) throws Exception {
	 * updateFile(new File(file), marks); }
	 */

	/*
	 * public void updateFile(File file, ArrayList marks) throws Exception { if
	 * (Valida.isEmpty(marks)) return;
	 * 
	 * if ((file == null) || (!file.exists()) || (!file.isFile())) { throw new
	 * Exception("O arquivo " + file.getAbsolutePath() +
	 * " nao e um arquivo valido"); } RandomAccessFile rand = null; try { int
	 * eol = eolLength(file.getAbsolutePath());
	 * 
	 * rand = new RandomAccessFile(file, "rw");
	 * 
	 * long pos = 0L; for (int idx = 0; idx < marks.size(); idx++) { MarkVO mark
	 * = (MarkVO)marks.get(idx); if (mark.isProcessed()) { String valNovo =
	 * mark.getValorNovo(); if (valNovo != null) { pos = (mark.getLinArq() - 1L)
	 * * eol + mark.getByteini() + mark.getPosini();
	 * 
	 * rand.seek(pos); rand.write(valNovo.getBytes(), 0, valNovo.length()); } }
	 * } } finally { if (rand != null) { rand.close(); rand = null; } } }
	 */
}
