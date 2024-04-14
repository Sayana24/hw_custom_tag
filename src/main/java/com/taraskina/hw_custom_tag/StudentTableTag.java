package com.taraskina.hw_custom_tag;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.BodyTagSupport;

import java.io.IOException;

public class StudentTableTag extends BodyTagSupport {
    private int rows;
    private String head;

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setHead(String head) {
        this.head = head;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            out.write("<table>");
            out.write("<thead><tr><th>" + head + "</th></tr></thead>");
            out.write("<tbody><tr><td>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doAfterBody() throws JspException {
        if (rows-- > 1){
            try {
                pageContext.getOut().write("</td></tr><tr><td>");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return EVAL_BODY_AGAIN;
        } else {
            return SKIP_BODY;
        }
    }
    @Override
    public int doEndTag() throws JspException {

        try {
            pageContext.getOut().write("</td></tr></tbody></table>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return EVAL_PAGE;
    }

}
