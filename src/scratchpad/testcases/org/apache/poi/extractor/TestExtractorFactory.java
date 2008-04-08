/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */
package org.apache.poi.extractor;

import java.io.File;

import org.apache.poi.hslf.extractor.PowerPointExtractor;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xslf.extractor.XSLFPowerPointExtractor;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import junit.framework.TestCase;

/**
 * Test that the extractor factory plays nicely
 */
public class TestExtractorFactory extends TestCase {
	private String excel_dir;
	private String word_dir;
	private String powerpoint_dir;
	
	private File txt;
	
	private File xls;
	private File xlsx;
	
	private File doc;
	private File docx;

	private File ppt;
	private File pptx;

	protected void setUp() throws Exception {
		super.setUp();
		
		excel_dir = System.getProperty("HSSF.testdata.path");
		word_dir = System.getProperty("HWPF.testdata.path");
		powerpoint_dir = System.getProperty("HSLF.testdata.path");
		
		txt = new File(excel_dir, "SampleSS.txt");
		
		xls = new File(excel_dir, "SampleSS.xls");
		xlsx = new File(excel_dir, "SampleSS.xlsx");
		
		doc = new File(word_dir, "SampleDoc.doc");
		docx = new File(word_dir, "SampleDoc.docx");
		
		ppt = new File(powerpoint_dir, "SampleShow.ppt");
		pptx = new File(powerpoint_dir, "SampleShow.pptx");
	}

	public void testFile() throws Exception {
		// Excel
		assertTrue(
				ExtractorFactory.createExtractor(xls)
				instanceof ExcelExtractor
		);
		assertTrue(
				ExtractorFactory.createExtractor(xls).getText().length() > 200
		);
		
		assertTrue(
				ExtractorFactory.createExtractor(xlsx)
				instanceof XSSFExcelExtractor
		);
		assertTrue(
				ExtractorFactory.createExtractor(xlsx).getText().length() > 200
		);
		
		// Word
		assertTrue(
				ExtractorFactory.createExtractor(doc)
				instanceof WordExtractor
		);
		assertTrue(
				ExtractorFactory.createExtractor(doc).getText().length() > 120
		);
		
		assertTrue(
				ExtractorFactory.createExtractor(docx)
				instanceof XWPFWordExtractor
		);
		assertTrue(
				ExtractorFactory.createExtractor(docx).getText().length() > 120
		);
		
		// PowerPoint
		assertTrue(
				ExtractorFactory.createExtractor(ppt)
				instanceof PowerPointExtractor
		);
		assertTrue(
				ExtractorFactory.createExtractor(ppt).getText().length() > 120
		);
		
		assertTrue(
				ExtractorFactory.createExtractor(pptx)
				instanceof XSLFPowerPointExtractor
		);
		assertTrue(
				ExtractorFactory.createExtractor(pptx).getText().length() > 120
		);
		
		// Visio
		// TODO
		
		// Text
		try {
			ExtractorFactory.createExtractor(txt);
			fail();
		} catch(IllegalArgumentException e) {
			// Good
		}
	}
	public void testInputStream() throws Exception {
		
	}
	public void testPOIFS() throws Exception {
		
	}
	public void testPackage() throws Exception {
		
	}
}
