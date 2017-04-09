<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="edge" />
		<meta name="renderer" content="webkit">
		<meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<link type="image/x-icon" rel="shortcut icon" href="/static/resource/favicon.ico" />
		<title>IAG</title>
		<link rel="stylesheet" href="/static/resource/others/swiper/swiper.css" />
		<link rel="stylesheet" href="/static/resource/css/bootstrap.css" />
		<link rel="stylesheet" href="/static/resource/css/style.css" />
	</head>

	<body>
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="col-lg-1 col-md-1"></div>
			<div class="col-lg-10 col-md-10">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example-navbar-collapse">
							<span class="sr-only">切换导航</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a href="index.html" class="navbar-brand logo" style="color: #fff;" href="#"></a>
					</div>
					<div class="collapse navbar-collapse" id="example-navbar-collapse">
						<ul class="nav navbar-nav">
							<li>
								<a style="color: #fff;" href="#"><span class="glyphicon glyphicon-list-alt"></span> 文章</a>
							</li>
							<li>
								<a style="color: #fff;" href="#"><span class="glyphicon glyphicon-filter"></span> 专题</a>
							</li>
							<li>
								<a style="color: #fff;" href="#"><span class="glyphicon glyphicon-comment"></span> 冒泡</a>
							</li>
							<li>
								<a style="color: #fff;" href="#"><span class="glyphicon glyphicon-book"></span> 关于我们</a>
							</li>
						</ul>
						<ul class="nav navbar-nav navbar-right" style="color: #fff;">
							<li>
								<a href="#" style="color: #fff;"><span class="glyphicon glyphicon-user"></span> 登录</a>
							</li>
							<li>
								<a href="#" style="color: #fff;"><span class="glyphicon glyphicon-edit"></span> 注册</a>
							</li>
						</ul>

					</div>
				</div>
			</div>
			<div class="col-lg-1 col-md-1"></div>
		</nav>
		<div class="content">
			<div class="col-lg-1 col-md-1"></div>
			<div class="col-lg-10 col-md-10">
				<div class="col-lg-8 col-md-8">
					<div class="search-box">
						<!--搜索-->
						<input type="text" class="search-input" placeholder="请输入搜索内容" />
						<button type="submit" class="search-btn">搜索</button>
					</div>
					<div class="art-list">
						<div class="art-top">
							<span class="glyphicon glyphicon-list-alt"></span> 文章阅读
							<div class="art-top-right">
								<a href="" class="btn-release">发布文章</a>
							</div>
						</div>
						<div class="art-body">
                            <#list page.data as posts>
							<div class="article">
								<div class="art-left">
									<div class="art-title">
										<a href="article_detail.html">
                                            ${posts.title}
                                        </a>
										<span class="lab2 lab-d">java</span>
										<span class="lab2 lab-d">html</span>
									</div>
									<div class="art-time">
										<a href="#" title="点击访问作者主页">
                                            <img src="/static/resource/img/user.png" title="头像" />
                                            <span>${posts.user.nickname}</span></a>
										<span><i class="glyphicon glyphicon-eye-open"></i>
                                            ${posts.viewNum}
                                        </span>
										<span><i class="glyphicon glyphicon-thumbs-up"></i>
                                            ${posts.praiseNum}
                                        </span>
										<span><i class="glyphicon glyphicon-comment"></i> 123</span>
										<span><i class="glyphicon glyphicon-time"></i>
                                            ${posts.publishTime}
                                        </span>
									</div>
								</div>
								<div style="clear: both;"></div>
							</div>
                            </#list>
						</div>
						<div class="art-pages">
							<ul class="pagination">
								<li>
									<a href="#">&laquo;</a>
								</li>
								<li>
									<a href="#">1</a>
								</li>
								<li>
									<a href="#">2</a>
								</li>
								<li>
									<a href="#">3</a>
								</li>
								<li>
									<a href="#">4</a>
								</li>
								<li>
									<a href="#">5</a>
								</li>
								<li>
									<a href="#">6</a>
								</li>
								<li>
									<a href="#">&raquo;</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-4">
					<div class="ph">
						<div class="ph-top"><span class="glyphicon glyphicon-fire"></span> 热门推荐</div>
						<div class="ph-body">
							<ul>
								<li>
									<a><span class="glyphicon glyphicon-screenshot"></span> 这些编码习惯你知道吗？这些编码习惯你知道吗？这些编码习惯你知道吗？</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-screenshot"></span> 这些编码习惯你知道吗？这些编码习惯你知道吗？</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-screenshot"></span> 这些编码习惯你知道吗？</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-screenshot"></span> 这些编码习惯你知道吗？这些编码习惯你知道吗？这些编码习惯你知道吗？</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-screenshot"></span> 这些编码习惯你知道吗？</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-screenshot"></span> 这些编码习惯你知道吗？这些编码习惯你知道吗？</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-screenshot"></span> 这些编码习惯你知道吗？</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-screenshot"></span> 这些编码习惯你知道吗？</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-screenshot"></span> 这些编码习惯你知道吗？</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-screenshot"></span> 这些编码习惯你知道吗？</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="ph">
						<div class="ph-top"><span class="glyphicon glyphicon-tag"></span> 标签分类</div>
						<div class="ph-body">
							<span class="lab lab-d">java</span>
							<span class="lab lab-d">html</span>
							<span class="lab lab-d">php</span>
							<span class="lab lab-d">css</span>
							<span class="lab lab-d">css3</span>
							<span class="lab lab-d">C语言</span>
							<span class="lab lab-d">数据库</span>
							<span class="lab lab-d">平面设计</span>
							<span class="lab lab-d">UI设计</span>
							<span class="lab lab-d">php</span>
							<span class="lab lab-d">javascript</span>
							<span class="lab lab-d">css3</span>
							<span class="lab lab-d">C语言</span>
							<span class="lab lab-d">数据库</span>
							<span class="lab lab-d">数据库</span>
							<span class="lab lab-d">java</span>
							<span class="lab lab-d">html</span>
							<span class="lab lab-d">php</span>
							<span class="lab lab-d">css</span>
							<span class="lab lab-d">css3</span>
							<span class="lab lab-d">C语言</span>
							<span class="lab lab-d">数据库</span>
							<span class="lab lab-d">数据库</span>
							<span class="lab lab-d">java</span>
							<span class="lab lab-d">html</span>
							<span class="lab lab-d">php</span>
							<span class="lab lab-d">css</span>
							<span class="lab lab-d">css3</span>
							<span class="lab lab-d">C语言</span>
							<span class="lab lab-d">数据库</span>
						</div>
					</div>
					<div class="ph">
						<div class="ph-top"><span class="glyphicon glyphicon-globe"></span> 技术热点</div>
						<div class="ph-body">
							<ul>
								<li>
									<a><span class="glyphicon glyphicon-flag"></span> MD规范-Material Design篇!</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-flag"></span> MD规范-Material Design篇!？</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-flag"></span> MD规范-Material Design篇!？</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-flag"></span> MD规范-Material Design篇!？</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-flag"></span> MD规范-Material Design篇!？</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-flag"></span> MD规范-Material Design篇!？</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-flag"></span> MD规范-Material Design篇!？</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-flag"></span> MD规范-Material Design篇!？</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-flag"></span> MD规范-Material Design篇!？</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-flag"></span> MD规范-Material Design篇!？</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="ph">
						<div class="ph-top"><span class="glyphicon glyphicon-book"></span> 资料下载</div>
						<div class="ph-body">
							<ul>
								<li>
									<a><span class="glyphicon glyphicon-cloud-download"></span> 前端入门教程大全！前端入门教程大全！</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-cloud-download"></span> 前端入门教程大全！</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-cloud-download"></span> 前端入门教程大全！</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-cloud-download"></span> 前端入门教程大全！</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-cloud-download"></span> 前端入门教程大全！</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-cloud-download"></span> 前端入门教程大全！</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-cloud-download"></span> 前端入门教程大全！</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-cloud-download"></span> 前端入门教程大全！</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-cloud-download"></span> 前端入门教程大全！</a>
								</li>
								<li>
									<a><span class="glyphicon glyphicon-cloud-download"></span> 前端入门教程大全！</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="ph">
						<div class="ph-top"><span class="glyphicon glyphicon-send"></span> 友情链接</div>
						<div class="ph-body">
							<ul>
								<li>
									<a href="http://www.w3school.com.cn/" target="_blank" title="w3school 在线教程"><span class="glyphicon glyphicon-link"></span> w3school 在线教程</a>
								</li>
								<li>
									<a href="http://www.cnblogs.com/" target="_blank" title="博客园 - 开发者的网上家园"><span class="glyphicon glyphicon-link"></span> 博客园 - 开发者的网上家园</a>
								</li>
								<li>
									<a href="https://www.oschina.net/" target="_blank" title="开源中国 - 找到您想要的开源项目，分享和交流"><span class="glyphicon glyphicon-link"></span> 开源中国 - 找到您想要的开源项目，分享和交流</a>
								</li>
								<li>
									<a href="http://www.zhihu.com/" target="_blank" title="知乎"><span class="glyphicon glyphicon-link"></span> 知乎</a>
								</li>
								<li>
									<a href="http://www.runoob.com/" target="_blank" title="菜鸟教程 - 学的不仅是技术，更是梦想！"><span class="glyphicon glyphicon-link"></span> 菜鸟教程 - 学的不仅是技术，更是梦想！</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-1 col-md-1"></div>
		</div>
		<script type="text/javascript" src="/static/resource/js/jquery-3.0.0.js"></script>
		<script type="text/javascript" src="/static/resource/js/bootstrap.js"></script>
		<script type="text/javascript" src="/static/resource/others/swiper/swiper.js"></script>
		<script type="text/javascript" src="/static/resource/js/bbs.js"></script>

	</body>

</html>