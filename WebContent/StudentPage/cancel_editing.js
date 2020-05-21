cancel_btn = document.getElementById("button_panel__cancel_editing_btn");
cancel_btn.onclick = function() {
	parent_node = document.getElementById("main__rightbar");
	form_node = document.getElementById("info_editing_form");

	parent_child1 = document.getElementsByClassName("rightbar__top")[0];
	parent_child2 = document.getElementsByClassName("rightbar__bottom")[0];
	parent_child3 = document.getElementsByClassName("rightbar__button_panel")[0];

	parent_child1.remove();
	parent_child2.remove();
	parent_child3.remove();

	form_node.remove();

	parent_node.append(parent_child1);
	parent_node.append(parent_child2);
	parent_node.append(parent_child3);

	info_fields = document.getElementsByClassName("info_field__info");
	
	for (let i = 0; i < info_fields.length; i++) {
		info_fields[i].style = "display: inline";
	}

	form__inputs = document.getElementsByClassName("form__inputs");
	
	for (let i = form__inputs.length - 1; i >= 0; i--) {
		form__inputs[i].remove();
	}

	change_btn = document.getElementById("button_panel__change_save_btn");
	change_btn.style = "display: none";
	change_btn.type = "button";

	edit_btn = document.getElementById("button_panel__edit_btn");
	edit_btn.style = "display: block";
	edit_btn.type = "button";

	this.style = "display: none";
}