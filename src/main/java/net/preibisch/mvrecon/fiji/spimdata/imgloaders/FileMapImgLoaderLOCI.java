/*-
 * #%L
 * Software for the reconstruction of multi-view microscopic acquisitions
 * like Selective Plane Illumination Microscopy (SPIM) Data.
 * %%
 * Copyright (C) 2012 - 2017 Multiview Reconstruction developers.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */
package net.preibisch.mvrecon.fiji.spimdata.imgloaders;

import java.io.File;
import java.util.HashMap;

import mpicbg.spim.data.generic.sequence.AbstractSequenceDescription;
import mpicbg.spim.data.generic.sequence.BasicViewDescription;
import mpicbg.spim.data.legacy.LegacyImgLoaderWrapper;
import net.imglib2.img.ImgFactory;
import net.imglib2.type.NativeType;
import net.imglib2.type.numeric.integer.UnsignedShortType;
import net.imglib2.util.Pair;
import net.preibisch.mvrecon.fiji.spimdata.imgloaders.filemap2.FileMapGettable;

public class FileMapImgLoaderLOCI extends LegacyImgLoaderWrapper< UnsignedShortType, LegacyFileMapImgLoaderLOCI > implements FileMapGettable
{

	public FileMapImgLoaderLOCI(
			HashMap<BasicViewDescription< ? >, Pair<File, Pair<Integer, Integer>>> fileMap,
			final ImgFactory< ? extends NativeType< ? > > imgFactory,
			final AbstractSequenceDescription<?, ?, ?> sequenceDescription )
	{
		super( new LegacyFileMapImgLoaderLOCI( fileMap, imgFactory, sequenceDescription ) );
	}

	public ImgFactory< ? extends NativeType< ? > > getImgFactory() { return legacyImgLoader.getImgFactory(); }
	public void setImgFactory(ImgFactory< ? extends NativeType< ? > > factory){legacyImgLoader.setImgFactory( factory );}

	@Override
	public String toString() {
		return legacyImgLoader.toString();
	}
	
	@Override
	public HashMap< BasicViewDescription< ? >, Pair< File, Pair< Integer, Integer > > > getFileMap()
	{
		 return ( (LegacyFileMapImgLoaderLOCI) legacyImgLoader ).getFileMap();
	}
	

}
