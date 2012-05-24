<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>  

<h3 class="titre3">Mes classes</h3>


<% int cpt = 0; %>


<div id="accordion">
	<c:forEach items="${lesClasses}" var="classe">
		<% cpt++; %>
		<h3>
			<a href="#">${classe.nom}</a>
		</h3>
		<div>
			<table id="<%=cpt%>" class="tablesorter">
				<thead>
					<tr class="header">
						<th>Eleves</th>
						<th>Nombre d'actions par type</th>
						<th>Temps Total</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${lesEleves}" var="eleve">
						<c:if test="${classe.nom == eleve.classe.nom}">
							<tr>
								<td>${eleve.nom} ${eleve.prenom}</td>
								<td style="text-align:left;">
									<c:forEach items="${lesAP}" var="ap">
										<c:if test="${eleve.id == ap.idEleve}">
											${ap.count} - ${ap.nom}<br>
										</c:if>
									</c:forEach>
								</td>
								<td><fmt:formatNumber value="${(eleve.dureeTotal/60)-((eleve.dureeTotal%60)/60)}" pattern="#0" />h ${(eleve.dureeTotal%60)}min</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:forEach>
</div>