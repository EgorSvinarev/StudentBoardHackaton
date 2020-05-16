elem = document.getElementById("output_regulation_panel__alphabet_sort");
elem.onclick = function() {
	entries_fields = document.getElementsByClassName("entry_surname");
	
	data = [];
	
	for(let i = 0; i < entries_fields.length; i++) {
		parent = entries_fields[i].parentNode;
		data.push({surname : entries_fields[i].innerHTML, parent : parent});
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
		data.sort(dynamicSort("surname"));
		this.innerHTML = "А-Я";
		this.value = "backward";
	}
	else {
		data.sort(dynamicSort("-surname"));
		this.innerHTML = "Я-А";
		this.value = "forward";
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