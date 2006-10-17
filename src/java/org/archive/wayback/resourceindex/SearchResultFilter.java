/* SearchResultFilter
 *
 * $Id$
 *
 * Created on 3:17:02 PM Aug 17, 2006.
 *
 * Copyright (C) 2006 Internet Archive.
 *
 * This file is part of Wayback.
 *
 * Wayback is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * any later version.
 *
 * Wayback is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser Public License for more details.
 *
 * You should have received a copy of the GNU Lesser Public License
 * along with Wayback; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package org.archive.wayback.resourceindex;

import org.archive.wayback.core.SearchResult;
import org.archive.wayback.util.ObjectFilter;

/**
 * Adapter of ObjectFilter to SearchResult-specific filter.
 *
 * @author brad
 * @version $Date$, $Revision$
 */
public abstract class SearchResultFilter implements ObjectFilter {

	/**
	 * @param r SearchResult to possibly filter
	 * @return FILTER_INCLUDE, FILTER_EXCLUDE, or FILTER_ABORT
	 */
	public abstract int filterSearchResult(SearchResult r);
	
	/* (non-Javadoc)
	 * @see org.archive.wayback.util.ObjectFilter#filterObject(java.lang.Object)
	 */
	public int filterObject(Object o) {
		if(!(o instanceof SearchResult)) {
			throw new IllegalArgumentException("Need SearchResult");
		}
		return filterSearchResult((SearchResult) o);
	}
}
