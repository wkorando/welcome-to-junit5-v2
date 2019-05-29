package com.bk.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.io.TempDir;

@TestMethodOrder(OrderAnnotation.class)
public class TestTempDir {

	@TempDir
	static Path classTempDir;
	
	@TempDir
	static File classTempDirAsFile;

	@Test
	@Order(1)
	public void useAsClassValue() throws IOException {
		File file = classTempDir.resolve("temp.txt").toFile();
		FileUtils.write(file, "A", StandardCharsets.ISO_8859_1, true);
		assertEquals("A", FileUtils.readFileToString(file, StandardCharsets.ISO_8859_1));
	}

	@Test
	@Order(2)
	public void useAsClassValuePart2() throws IOException {
		File file = classTempDir.resolve("temp.txt").toFile();
		FileUtils.write(file, "B", StandardCharsets.ISO_8859_1, true);
		assertEquals("AB", FileUtils.readFileToString(file, StandardCharsets.ISO_8859_1));
	}

	@Test
	@Order(3)
	public void injectAsMethodValue(@TempDir Path argumentTempDir) throws IOException {
		File file = argumentTempDir.resolve("temp.txt").toFile();
		FileUtils.write(file, "C", StandardCharsets.ISO_8859_1, true);
		assertEquals("ABC", FileUtils.readFileToString(file, StandardCharsets.ISO_8859_1));
	}
	
	@Test
	@Order(4)
	public void injectAsMethodValuePart2(@TempDir Path argumentTempDir) throws IOException {
		File file = argumentTempDir.resolve("temp.txt").toFile();
		FileUtils.write(file, "D", StandardCharsets.ISO_8859_1, true);
		assertEquals("ABCD", FileUtils.readFileToString(file, StandardCharsets.ISO_8859_1));
	}
	
	@Test
	@Order(5)
	public void injectAsMethodValuePart2() throws IOException {
		File file = new File(classTempDirAsFile, "temp.txt");
		FileUtils.write(file, "E", StandardCharsets.ISO_8859_1, true);
		assertEquals("ABCDE", FileUtils.readFileToString(file, StandardCharsets.ISO_8859_1));
	}
	
	@Test
	@Order(6)
	public void injectAsMethodValuePart2(@TempDir File tempFile) throws IOException {
		File file = new File(classTempDirAsFile, "temp.txt");
		FileUtils.write(file, "F", StandardCharsets.ISO_8859_1, true);
		assertEquals("ABCDEF", FileUtils.readFileToString(file, StandardCharsets.ISO_8859_1));
	}
}