
function getAuditHistory() {
    var historyTable = document.getElementById("myTable");
    var xmlRequest = new XMLHttpRequest();

    xmlRequest.onreadystatechange = function () {
        if(this.readyState === 4 && this.status === 200) {
            var jsonParsed = JSON.parse(this.responseText);
            fillTable(historyTable,jsonParsed)
        }
    };
    xmlRequest.open("GET", "/history", true);
    xmlRequest.send();
}

function fillTable(table, jsonParsed) {
    for (var i = 0; i < jsonParsed[1].length; i++) {
    	JSON.stringify(jsonParsed[1][i]) + "<br>"
    }
}