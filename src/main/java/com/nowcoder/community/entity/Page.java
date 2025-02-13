package com.nowcoder.community.entity;

/**
 * 封装分页相关的信息
 */
public class Page {
    //当前页码
    private int current = 1;


    private int limit = 10;//显示设置
    private int rows; //数据总数 用于计算页数


    private String path;//查询路径 用于复用分页链接

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current >= 1){
        this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit>=1 && limit<=100){
        this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows >= 0){
        this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //获取当前页起始行
    public int getOffset(){
        return (current-1)*limit;
    }
    /**
     * 获取总页数
     *
     * @return the total
     */
    public int getTotal() {
        // rows / limit [+1]
        if ((rows % limit) == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }

    /**
     * 获取起始页码  显示出来
     *
     * @return the from
     */
    public int getFrom() {
        int from = current - 2;
        return Math.max(from, 1);
    }

    /**
     * 获取终止页码 显示出来
     *
     * @return the to
     */
    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return Math.min(to, total);
    }
}
