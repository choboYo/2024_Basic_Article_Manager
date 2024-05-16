package com.koreaIT.BAM.service;

import java.util.List;

import com.koreaIT.BAM.dao.ArticleDao;
import com.koreaIT.BAM.dto.Article;

public class ArticleService {

	private ArticleDao articleDao;
	
	public ArticleService() {
		this.articleDao = new ArticleDao();
	}

	public int writeArticle(int memberId, String title, String body, int viewCnt) {
		return articleDao.writeArticle(memberId, title, body, viewCnt);
	}

	public List<Article> articleList(String searchKeyword, List<Article> printArticles) {
		return articleDao.articleList(searchKeyword, printArticles);
	}

}