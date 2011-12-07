package com.ecomm.brewer.util.list;

import java.util.List;

/**
* An extension of the {@link java.util.List} interface for use in JSPs,
* to allow display of a paginated list.
*
* For example, the JSTL construct &lt;c:forEach&gt; can be populated with this type,
* to allow simple instantiation of the necessary variables.
*
 * @author Gavin Costello (gavcos@gmail.com).
*/
public interface Pageable<E> extends List<E> {

    /**
     * The number of pages in the list
     */
    public int getNumberOfPages();

    /**
     * Returns the currently selected page.
     *
     * @return int  The current page.
     */
    public int getCurrentPage();

    /**
     * Sets the current page.
     * On instantiation, this should be set to 1.
     *
     * @param   page    The page to set.
     */
    public void setCurrentPage(int page);

    /**
     * Sets the page size.
     *
     * @param   pageSize    The page size to set.
     */
    public void setPageSize(int pageSize);

    /**
     * Returns the current page size.
     *
     * @param int   The page size.
     */
    public int getPageSize();

    /**
     * Returns the index the first row of the current page.
     *
     * @return  int The index.
     */
    public int getFirstIndexOfCurrentPage();

    /**
     * Returns the index of the last row of the current page.
     *
     * @return  int The index.
     */
    public int getLastIndexOfCurrentPage();
}
