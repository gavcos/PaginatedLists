package com.ecomm.brewer.util.list;

import java.util.ArrayList;
import java.util.Collection;

/**
* @see {@link nsi.fonctionnel.partnens.technique.util.Pageable}.
* @author Gavin Costello (gavcos@gmail.com).
*/
public class PagedList<E> extends ArrayList<E> implements Pageable<E> {

    private static final long serialVersionUID = 3469596120762185396L;
    /** The page size */
    private int pageSize;
    /** Default page */
    private static final int DEFAULT_PAGE = 1;
    /** Default page size */
    private static final int DEFAULT_PAGE_SIZE = 20;
    /** The currently selected page, initially the first one. */
    private int currentPage = DEFAULT_PAGE;

    /** Default constructor, initialises page size to default. */
    public PagedList() {
        super();
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    /**
     * Calls super class and initialises page size to default.
     * @param initialCapacity   The initial size of the list.
     */
    public PagedList(int initialCapacity) {
        super(initialCapacity);
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    /**
     * Initialises the list with an initial capacity and a page size.
     * @param initialCapacity   The initial size of the list.
     * @param pageSize          The page size to set.
     */
    public PagedList(int initialCapacity, int pageSize) {
        super(initialCapacity);
        this.pageSize = pageSize;
    }

    /**
     * Calls super class and initialises page size to default.
     * @param c
     */
    public PagedList(Collection<E> c) {
        super(c);
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    /**
     * Returns the current page.
     *
     * @return int   The current page.
     */
    public int getCurrentPage() {
        return this.currentPage;
    }

    /**
     * Sets the current page.
     *
     * @param   int     The page to set as current.
     */
    public void setCurrentPage(int page) {
        this.currentPage = page;
    }

    /**
     * Sets the page size.
     *
     * @param   pageSize    The page size to set.
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Returns the current page size.
     *
     * @param int   The page size.
     */
    public int getPageSize() {
        return this.pageSize;
    }

    /**
     * Returns the number of pages in the list.
     * If the list is empty, returns zero.
     *
     * @return  int     The number of pages, based on the size of the list and the page size.
     */
    public int getNumberOfPages() {
        if (this.size() == 0 || this.pageSize == 0) {
            return 0;
        } else {
            int iDiv =  this.size() / this.pageSize;
            int iModulo = this.size() % this.pageSize;
            return iModulo == 0 ? iDiv : ++iDiv;
        }
    }

    /**
     * Returns the index of the first row of the current page.
     *
     * @return  int     The index of the current page's first element.
     */
    public int getFirstIndexOfCurrentPage() {
        if (getCurrentPage() < 2) {
            return 0;
        } else {
            return (getCurrentPage() - 1) * this.pageSize;
        }
    }

    /**
     * Returns the index of the last row of the current page.
     *
     * @return  int     The index of the current page's last element.
     */
    public int getLastIndexOfCurrentPage() {
        return getFirstIndexOfCurrentPage() + (this.pageSize - 1);
    }
}
