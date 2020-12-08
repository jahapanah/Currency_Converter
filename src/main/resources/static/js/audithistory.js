<script>
  function getAuditHistory() {
    const table = document.getElementById("history");
    items.forEach( item => {
      let row = table.insertRow();
      let date = row.insertCell(0);
      date.innerHTML = item.date;
      let name = row.insertCell(1);
      name.innerHTML = item.name;
    });
  }
getHistory();
</script>