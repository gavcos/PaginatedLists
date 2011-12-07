<c:set var="noPages">
    <%= getList().getNumberOfPages() %> 
</c:set>
<c:set var="currentPage">
    <% getList().getCurrentPage() %> 
</c:set>
<c:set var="startIndex">
    <%= getList().getFirstIndexOfCurrentPage() %> 
</c:set>
<c:set var="endIndex">
    <% getList().getLastIndexOfCurrentPage() %> 
</c:set> 
<c:if test="${not empty people}">
    <c:if test="${noPages ne '1'}">
        <tr>
            <td>${currentPage}&nbsp;/&nbsp;${noPages}</td> 
        </tr>
        <c:forEach var="person" items="people" begin="startIndex" end="endIndex" varStatus="status">
            <tr>
                <td>${person.name}</td>
                <td>${person.firstName}</td>
            </tr> 
        </c:forEach>


        <c:if test="${pageNo ne '1'}">
            <tr>
                <td>
                    <c:forEach var="i"  begin="0" end="noPages">
                        <c:choose>
                            <c:when test="${currentPage eq i}">
                            </c:when>
                            <c:otherwise>
                                <a href="select-page-link">Select</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </td>
            </tr>
        </c:if>
    </c:if>
</c:if>
