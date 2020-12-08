
var xmlRequest = new XMLHttpRequest();
var items
xmlRequest.onreadystatechange = function () {
    if (this.readyState === 4 && this.status === 200) {
        items = JSON.parse(this.responseText);
    }
}

function getAuditHistory() {
    const table = document.getElementById("history");
    items.forEach(item => {
        let row = table.insertRow();
        let date = row.insertCell(0);
        date.innerHTML = item.date;
        let name = row.insertCell(1);
        name.innerHTML = item.name;
    });
}

getAuditHistory();