package cn.nnu.jyjs.etpweb.bean;

/**
 * @Project :   etpweb
 * @Time :   11/15/2018 20:59
 * @Auther :   wangj
 * @Description:
 */
public class Page {

    private int pageCount;

    private int pageSize = 15;

    private int currentPage = 1;

    private int itemsCount;

    private boolean isFirstPage;

    private boolean isLastPage;

    private boolean hasNestPage;

    private boolean hasProPage;

    public Page(int pageCount, int pageSize, int currentPage, boolean isFirstPage, boolean isLastPage, boolean hasNestPage, boolean hasProPage) {
        this.pageCount = pageCount;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.isFirstPage = isFirstPage;
        this.isLastPage = isLastPage;
        this.hasNestPage = hasNestPage;
        this.hasProPage = hasProPage;
    }

    public Page(int pageSize, int itemsCount) {
        this.pageSize = pageSize;
        this.itemsCount = itemsCount;
        this.pageCount = (int)(itemsCount * 1.0 / pageSize + 0.5);
    }

    /**
     * default page size = 15
     */
    public Page(int itemsCount){
        this.pageSize = 15;
        this.itemsCount = itemsCount;
        this.pageCount = (int)(itemsCount * 1.0 / pageSize + 0.5);
    }


    public Page(){
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }
    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public boolean isFirstPage() {
        return this.currentPage == 1 ? true : false;
    }

    public boolean isLastPage() {
        return this.currentPage == pageCount ? true : false;
    }

    public boolean isHasNestPage() {
        return isLastPage();
    }

    public boolean isHasProPage() {
        return isFirstPage();
    }

}
