/*
TOD - Trace Oriented Debugger.
Copyright (c) 2006-2008, Guillaume Pothier
All rights reserved.

This program is free software; you can redistribute it and/or 
modify it under the terms of the GNU General Public License 
version 2 as published by the Free Software Foundation.

This program is distributed in the hope that it will be useful, 
but WITHOUT ANY WARRANTY; without even the implied warranty of 
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
General Public License for more details.

You should have received a copy of the GNU General Public License 
along with this program; if not, write to the Free Software 
Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
MA 02111-1307 USA

Parts of this work rely on the MD5 algorithm "derived from the 
RSA Data Security, Inc. MD5 Message-Digest Algorithm".
*/
package tod.impl.common.event;

import tod.core.database.browser.ILogBrowser;
import tod.core.database.event.INewArrayEvent;
import tod.core.database.structure.IArrayTypeInfo;

public class NewArrayEvent extends Event
implements INewArrayEvent
{ 
	private Object itsInstance;
	private IArrayTypeInfo itsType;
	private int itsArraySize;

	public NewArrayEvent(ILogBrowser aLogBrowser)
	{
		super(aLogBrowser);
	}

	public Object getInstance()
	{
		return itsInstance;
	}

	public void setInstance(Object aInstance)
	{
		itsInstance = aInstance;
	}

	public IArrayTypeInfo getType()
	{
		return itsType;
	}

	public void setType(IArrayTypeInfo aType)
	{
		itsType = aType;
	}

	public int getArraySize()
	{
		return itsArraySize;
	}

	public void setArraySize(int aArraySize)
	{
		itsArraySize = aArraySize;
	}

}
