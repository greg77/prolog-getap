<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="nav">
	<div class="table">

		<c:if test="${user.role == 'eleve'}">
			<ul class="select">
				<li><a href="<c:url value="/app/eleve/index" />" target="_self"><b>Mes demandes</b>
				</a></li>
			</ul>
		</c:if>


		<c:if test="${user.role == 'prof-principal'}">
			<ul class="select">
				<li><a href="<c:url value="/app/prof-principal/index" />" target="_self"><b>Mes classes</b></a></li>
			</ul>
		</c:if>


		<c:if test="${user.role == 'prof-intervenant' or user.role == 'prof-principal'}">
			<ul class="select">
				<li><a href="<c:url value="/app/prof-intervenant/index" />" target="_self"><b>Mes demandes</b></a></li>
			</ul>
		</c:if>


		<c:if test="${user.role == 'admin'}">
			<ul class="select">
				<li><a href="<c:url value="/app/admin/index" />" target="_self"><b>Administration</b>
				</a>
				</li>
			</ul>
		</c:if>


		<c:if test="${user.role == null}">
			<ul class="select">
				<li><a class="co" href="<c:url value="/app/login/index" />" target="_self">
						<img src="<c:url value="../../images/CoTransparent.png"/>" /> </a>
				</li>
			</ul>
		</c:if>

		<c:if test="${user.role != null}">
			<ul class="select">
				<li><a href="<c:url value="/app/profil/edit?id=${user.id}"/>" taget="_self"><b>Mon compte</b></a></li>
				<li><a class="deco" href="<c:url value="/app/login/logout" />"
					target="_self"><img src="<c:url value="../../images/CoTransparent.png"/>" />
				</a>
				</li>
				
				<%-- <li><img class="deco" src="<c:url value="../../images/BoutonTransparent.png"/>" /></li> --%>
			</ul>
		</c:if>

	</div>
</div>

