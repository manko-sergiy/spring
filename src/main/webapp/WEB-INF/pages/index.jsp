<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="shortcut icon" href="/img/favicon.ico">
		
		<link rel="stylesheet"  href="/css/jquery.mobile-1.4.2.css">
		<link rel="stylesheet" href="/css/main.css">
		
		<script src="/js/jquery.js"></script>
		<script src="/js/jquery.mobile-1.4.2.js"></script>
		<script src="/js/main.js"></script>
		
		<title>Index</title>
	
	</head>
	
	<body>
		<div data-role="page" class="jqm-demos jqm-home">
			<div data-role="header" >
				<h2><img src="/img/logo.jpg" alt="Alt"></h2>
			</div><!-- /header -->
			
			<div role="main" class="ui-content jqm-content">

				<h1>Demos</h1>
		
	        	<div class="ui-block-b">
	        		<div class="jqm-block-content">
	        			<h3>Form widgets</h3>
	
	        			<p><a href="checkboxradio-checkbox/" data-ajax="false">Checkboxes</a>, <a href="checkboxradio-radio/" data-ajax="false">Radio buttons</a></p>
	        			<p><a href="selectmenu/" data-ajax="false">Selectmenu</a>, <a href="selectmenu-custom/" data-ajax="false">Custom menu</a></p>
	        			<p><a href="flipswitch/" data-ajax="false">Flipswitch</a></p>
	        			<p><a href="slider/" data-ajax="false">Slider</a>, <a href="rangeslider/" data-ajax="false">Rangeslider</a></p>
	        			<p><a href="button/" data-ajax="false">Input button</a></p>
	        			<p><a href="controlgroup/" data-ajax="false">Controlgroup</a></p>
	        		</div>
	        	</div>
		
			</div><!-- /content -->
			
			<div data-role="panel" class="jqm-navmenu-panel" data-position="left" data-display="overlay" data-theme="a">
				
			</div><!-- /panel -->
			
			<div data-role="footer" data-position="fixed" data-tap-toggle="false">
				<p>Copyright 2014</p>
			</div><!-- /footer -->
			
		</div><!-- /page -->
	</body>

</html>