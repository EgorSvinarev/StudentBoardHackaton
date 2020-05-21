edit_btn = document.getElementById("button_panel__edit_btn");
edit_btn.onclick = function() {
	parent_node = document.getElementById("main__rightbar");

	parent_child1 = document.getElementsByClassName("rightbar__top")[0];
	parent_child2 = document.getElementsByClassName("rightbar__bottom")[0];
	parent_child3 = document.getElementsByClassName("rightbar__button_panel")[0];

	parent_child1.remove();
	parent_child2.remove();
	parent_child3.remove();

	form_node = document.createElement("form");
	form_node.action = "student?" + document.location.href.match(/id=\d+/)[0];

	form_node.method = "post";
	form_node.id = "info_editing_form";
	form_node.style = "width: 100%; height: 100%";

	form_node.append(parent_child1);
	form_node.append(parent_child2);
	form_node.append(parent_child3);

	parent_node.append(form_node);
	
	info_fields = document.getElementsByClassName("info_field__info");
	
	for (let i = 0; i < info_fields.length; i++) {
		info_fields[i].style = "display: none";
	}

	form_fields = document.getElementsByClassName("rightbar__info_field");

	for (let i = 0; i < form_fields.length; i++) {
		field_input = document.createElement("input");
		field_input.type = "text";
		field_input.classList.add("form__inputs");
		field_input.name = form_fields[i].id;
		field_input.value = info_fields[i].innerHTML;

		if (form_fields[i].id != "id") {
			form_fields[i].append(field_input);	
		}
		

	}

	this.style = "display: none";

	change_btn = document.getElementById("button_panel__change_save_btn");
	change_btn.style = "display: block";
	change_btn.type = "submit";

	cancel_btn = document.getElementById("button_panel__cancel_editing_btn");
	cancel_btn.style = "display: block";

}