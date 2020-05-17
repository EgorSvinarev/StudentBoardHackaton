elem = document.getElementById("output_regulation_panel__groups_sort");
elem.onclick = function() {
	document.getElementById("output_regulation_panel__alphabet_sort").innerHTML="Алфавиту";
	entries_fields = document.getElementsByClassName("entry_group_id");
	
	data = [];
	
	for(let i = 0; i < entries_fields.length; i++) {
		parent = entries_fields[i].parentNode;
		data.push({group_id : entries_fields[i].innerHTML, parent : parent});
	}

	function dynamicSort(property) {
	    var sortOrder = 1;

	    if(property[0] === "-") {
	        sortOrder = -1;
	        property = property.substr(1);
	    }

	    return function (a,b) {
	        if(sortOrder == -1){
	            return b[property].localeCompare(a[property]);
	        }else{
	            return a[property].localeCompare(b[property]);
	        }        
	    }
	}

	if (this.value == "forward") {
		data.sort(dynamicSort("group_id"));
		this.value = "backward";
		this.innerHTML = "Возр.";
	}
	else {
		data.sort(dynamicSort("-group_id"));
		this.value = "forward";
		this.innerHTML = "Убыв.";
	}
	
	entries = document.getElementsByClassName("entry"); 
	for (let i = 0; i < entries.length; i++) {
		entries[i].remove();
	}

	table = document.getElementById("table__table");
	for (let i = 0; i < data.length; i++) {
		table.append(data[i].parent);
	}
}