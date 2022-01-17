<%-- 
    Document   : sidebar_1
    Created on : Dec 20, 2021, 9:48:10 AM
    Author     : pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="sidebar">
  <div class="user-profile">
    <div class="info-wrapper">
      <p class="user-name">
          <%=session.getAttribute("nomParking") %>
      </p>
    </div>
  </div>
  <ul class="navigation-menu">
    <li class="nav-category-divider">MAIN</li>
    
    <li>
      <a href="./gesParking.jsp">
        <span class="link-title">Gerer Parking</span>
        <i class="mdi mdi-gauge link-icon"></i>
      </a>
    </li>
    <li>
      <a href="./etage.jsp">
        <span class="link-title">Etages</span>
        <i class="mdi mdi-clipboard-outline link-icon"></i>
      </a>
    </li>
    <li>
      <a href="./section.jsp">
        <span class="link-title">Sections</span>
        <i class="mdi mdi-chart-donut link-icon"></i>
      </a>
    </li>
    <li>
      <a href="./place.jsp">
        <span class="link-title">Places</span>
        <i class="mdi mdi-flower-tulip-outline link-icon"></i>
      </a>
    </li>
  </ul>
</div>
