function f_alert(message,title,type)
{
	if(window.parent != window)
	{
		window.parent.f_alert(message,title,type);
	}
	else
		$.ligerDialog.alert(message, title, type);
}
function f_confirm(message,callback)
{
	if(window.parent != window)
	{
		window.parent.f_confirm(message,callback);
	}
	else
		$.ligerDialog.confirm(message, callback);
}

function f_waiting(message){
	if(window.parent != window)
	{
		return window.parent.f_waiting(message);
	}
	else
	{
	    var manager = $.ligerDialog.waitting(message);
	    return function ()
	    {
	        manager.close();
	    };
	}
}