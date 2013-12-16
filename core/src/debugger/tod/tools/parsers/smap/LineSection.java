/*
TOD - Trace Oriented Debugger.
Copyright (c) 2006-2008, Guillaume Pothier
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice, this 
      list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice, 
      this list of conditions and the following disclaimer in the documentation 
      and/or other materials provided with the distribution.
    * Neither the name of the University of Chile nor the names of its contributors 
      may be used to endorse or promote products derived from this software without 
      specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY 
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.

Parts of this work rely on the MD5 algorithm "derived from the RSA Data Security, 
Inc. MD5 Message-Digest Algorithm".
*/
package tod.tools.parsers.smap;

import java.util.List;

public class LineSection extends AbstractSection
{
	private final List<LineInfo> itsInfos;
	
	public LineSection(List<LineInfo> aInfos)
	{
		itsInfos = aInfos;
	}
	
	@Override
	public void addTo(SMAP aMap)
	{
		aMap.startLineSection();
		for (LineInfo theInfo : itsInfos) aMap.addLine(theInfo);
	}	
	
	public static class LineInfo
	{
		public final InputLineInfo in;
		public final OutputLineInfo out;

		public LineInfo(InputLineInfo aIn, OutputLineInfo aOut)
		{
			in = aIn;
			out = aOut;
		}
	}
	
	public static class InputLineInfo
	{
		public final StartLine startLine;
		public final int repeatCount;
		
		public InputLineInfo(StartLine aStartLine, int aRepeatCount)
		{
			startLine = aStartLine;
			repeatCount = aRepeatCount;
		}
	}
	
	public static class OutputLineInfo
	{
		public final StartLine startLine;
		public final int increment;
		
		public OutputLineInfo(StartLine aStartLine, int aIncrement)
		{
			startLine = aStartLine;
			increment = aIncrement;
		}
	}
	
	public static class StartLine
	{
		public final int number;
		public final int fileId;
		
		public StartLine(int aNumber, int aFileId)
		{
			number = aNumber;
			fileId = aFileId;
		}
	}
}
