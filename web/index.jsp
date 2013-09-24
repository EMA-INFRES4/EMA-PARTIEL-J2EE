<%-- 
    Document   : index
    Created on : 24 sept. 2013, 09:33:37
    Author     : xtalandier
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.tpj2ee.personne.PersonneBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

		<!-- Optional theme -->
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-theme.min.css">

		<!-- Latest compiled and minified JavaScript -->
		<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>

    </head>
    <body>
		<div class="container">
			<h1>TP J2EE</h1>
			<form method="post" action="/TP-J2EE/PersonneServlet" role="form" class="form-horizontal">
				<div class="form-group">
					<label class="col-lg-2 control-label" for="txtnom">Nom :</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" name="txtnom" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label" for="txtprenom">Prénom :</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" name="txtprenom" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label" for="cmbsexe">Sexe :</label>
					<div class="col-lg-10">
						<select name="cmbsexe" class="form-control">
							<option value="m"> Homme</option>
							<option value="f"> Femme</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label" for="cmbtransport">Transport :</label>
					<div class="col-lg-10">
						<select name="cmbtransport" multiple class="form-control">
							<option value="velo"> Vélo</option>
							<option value="voiture"> Voiture</option>
							<option value="apied"> A Pied</option>
							<option value="avion"> Avion</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label" for="txtcp">CP :</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" name="txtcp" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<button type="submit" class="btn btn-primary">Enregistrer</button>
					</div>
				</div>
			</form>
		</div>
		<div class="container">
			<table class="table table-bordered">
				<tr>
					<th>Nom</th>
					<th>Sexe</th>
					<th>CP</th>
					<th>Transport</th>
				</tr>
				<%
					ServletContext ctx = getServletContext();
					ArrayList<PersonneBean> personnes = (ArrayList<PersonneBean>) ctx.getAttribute("personnes");
					if (personnes == null) {
						personnes = new ArrayList<PersonneBean>();
					}
					int n = personnes.size();
					for (int i = 0; i < n; i++) {
						PersonneBean p = personnes.get(i);
				%>
				<tr>
					<td><%= p.getNom() + " " + p.getPrenom()%></td>
					<td><%= p.getSexe()%></td>
					<td><%= p.getCp()%></td>
					<td>
						<%
							String[] t = p.getTransport();
							for (int j = 0; j < t.length; j++) {
								out.println(t[j] + "<br />");
							}

						%>
					</td>
				</tr>
				<%
					}
				%>
			</table>
		</div>

	</body>
</html>
