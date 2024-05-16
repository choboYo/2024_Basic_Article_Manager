package com.koreaIT.BAM.dao;

import java.util.ArrayList;
import java.util.List;

import com.koreaIT.BAM.container.Container;
import com.koreaIT.BAM.dto.Article;
import com.koreaIT.BAM.util.Util;

public class ArticleDao {

	private List<Article> articles;
	private int lastId;
	
	public ArticleDao() {
		this.lastId = 1;
		this.articles = Container.articles;
	}

	public int writeArticle(int memberId, String title, String body, int viewCnt) {
		articles.add(new Article(lastId, Util.getDateStr(), memberId, title, body, viewCnt));
		return lastId++;
	}

	public List<Article> articleList(String searchKeyword, List<Article> printArticles) {
		
		for (Article article : articles) {
			if (article.getTitle().contains(searchKeyword)) {
				printArticles.add(article);
				return printArticles;
			}
		}
		
		return null;
	}

}