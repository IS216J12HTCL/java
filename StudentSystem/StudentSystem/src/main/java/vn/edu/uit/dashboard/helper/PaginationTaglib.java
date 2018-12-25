package vn.edu.uit.dashboard.helper;

import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PaginationTaglib extends SimpleTagSupport {
	private int currentPage;
	private int totalRecord;
	private int totalPage;

	private int limit = 0;
	private int start = 0;
	private String fullLink;
	private String firstLink;
	private int range = 0;
	private int min = 0;
	private int max = 0;
	
	private String params = "";
	private String pageParam = "page";
	private String previous = "Previous";
	private String next = "Next";

   
    private Writer getWriter() {
		JspWriter out = getJspContext().getOut();
		return out;
	}
    
    private List<String> paginating() {
    	int current = this.getCurrentPage();
    	int limit = this.getLimit();
    	int totalRecord = this.getTotalRecord();
    	int last = (int) Math.ceil((float)totalRecord/limit);
    	int delta = 2;
    	int	left = current - delta;
    	int	right = current + delta + 1;
    	List<String> range = new ArrayList<>();
    	List<String> rangeWithDots = new ArrayList<>();
    	int l = 0;
    	for (int i = 1; i <= last; i++) {
    		if (i == 1 || i == last || i >= left && i < right) {
                range.add(String.valueOf(i));
            }
		}
    	for (String i : range) {
            if (l > 0) {
                if (Integer.parseInt(i) - l == 2) {
                    rangeWithDots.add((String.valueOf(l + 1)));
                } else if (Integer.parseInt(i) - l != 1) {
                    rangeWithDots.add("...");
                }
               
            }
            rangeWithDots.add(i);
            l = Integer.parseInt(i);
        }
    	return rangeWithDots;
    }
    
    @Override
	public void doTag() throws JspException, UnsupportedEncodingException {
		Writer out = getWriter();
		List<String> pageList = this.paginating(); 
    	this.joinQuery();
		try {
			out.write("<nav>");
			out.write("<ul class=\"pagination\">");

			if(!pageList.isEmpty()) {
				if(currentPage==1)
					out.write(constructLink(1, previous, "disabled", true));
				else
					out.write(constructLink(currentPage - 1, previous, null, false));
			}
			
			for(String page : pageList) {
				
				if(page == "...") {
					out.write(constructLink(0, page, "disabled", true));
				}
				else if(Integer.parseInt(page) == this.currentPage){
					out.write(constructLink(Integer.parseInt(page), page, "active", true));
				}
				else {
					out.write(constructLink(Integer.parseInt(page), page, null, false));
				}
			}
			if(!pageList.isEmpty()) {
				if(currentPage>=totalPage)
					out.write(constructLink(currentPage, next, "disabled", true));
				else
					out.write(constructLink(currentPage + 1, next, null , false));
			}
			out.write("</ul>");
				
			out.write("</nav>");
		}
		catch (java.io.IOException ex) {
			throw new JspException("Error in Paginator tag", ex);
		}
	}
    
    private  Map<String, String> splitQuery(String query) throws UnsupportedEncodingException {
        Map<String, String> query_pairs = new LinkedHashMap<String, String>();
        String[] pairs = query.split("&");
        if(!query.isEmpty()) {
        	for (String pair : pairs) {
                int idx = pair.indexOf("=");
                query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
            }
        }
        return query_pairs;
    }
    
    public void joinQuery() throws UnsupportedEncodingException {
    	Map<String, String> params = this.splitQuery(this.getParams());
    	String queryString = "";
    	for (Map.Entry<String, String> param : params.entrySet()){
    		if(!param.getKey().equals(this.getPageParam())) {
    			queryString = queryString + "&" + param.getKey() + "=" + param.getValue();
    		}
    	}
    	queryString = queryString.replaceFirst("&", "");
    	this.setParams(queryString);
    }
    
    private String constructLink(int page, String text, String className, boolean disabled) {
    	StringBuilder link = new StringBuilder("<li");
    	link.append(" class=\"page-item ");
    	String uri = "";
    	if (className != null) {
    		link.append(className);
    	}
    	link.append("\"");
    	if(disabled) {
    		link.append(">").append("<a href=\"javascript:void(0);\"><span class=\"page-link\">"+text+"</span></a></li>");
    	} else {
    		if(params.isEmpty()) {
    			if(page > 0) {
    				link.append(">").append("<a class=\"page-link\" href=\""+uri+"?"+pageParam+"="+page +"\">"+text+"</a></li>");
    			}else {
    				link.append(">").append("<a class=\"page-link\" href=\""+uri+"\">"+text+"</a></li>");
    			}
    		} else {
    			if(page > 0) {
    				link.append(">").append("<a class=\"page-link\" href=\""+uri+"?" + params + "&"+pageParam+"="+page +"\">"+text+"</a></li>");
    			}
    			else {
    				link.append(">").append("<a class=\"page-link\" href=\""+uri+"?" + params + "&"+pageParam +"\">"+text+"</a></li>");
    			}
    		}
    	}
    	return link.toString();
    }
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public String getFullLink() {
		return this.fullLink;
	}

	public void setFullLink(String fullLink) {
		this.fullLink = fullLink;
	}

	public String getFirstLink() {
		return this.firstLink;
	}

	public void setFirstLink(String firstLink) {
		this.firstLink = firstLink;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getPageParam() {
		return pageParam;
	}

	public void setPageParam(String pageParam) {
		this.pageParam = pageParam;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}
}