var waitDialogCounter = 0;
var spinner = '<div id="followingBallsG"><div id="followingBallsG_1" class="followingBallsG"></div><div id="followingBallsG_2" class="followingBallsG"></div><div id="followingBallsG_3" class="followingBallsG"></div><div id="followingBallsG_4" class="followingBallsG"></div></div>';

var contextPath = '/EventManager';

var HttpGet = 'GET';
var HttpDelete = 'DELETE';
var HttpPost = 'POST';
var HttpPUT = 'PUT';

function loadElements() 
{
    loadNavBar();
    loadDateTimes();
    loadButtons();
    loadImages();
    loadFieldsets();
    loadCalendars();
}

jQuery(document).ready(function()
{
	jQuery('<div id="overlay">' + spinner + '</div>').css({
		position:   'fixed',
	    'z-index':    9999,
	    top:        0,
	    left:       0,
	    height:     '100%',
	    width:      '100%',
	    background: 'rgba( 200, 200, 200, .7 )' 	                
	}).hide().appendTo('body');
});

function showWaitingDialog()
{
	if (waitDialogCounter > 0)
		waitDialogCounter++;
	else
	{
		waitDialogCounter++;
		jQuery('#overlay').stop().fadeIn(200);
	}	
}

function closeWaitingDialog()
{
	if (waitDialogCounter > 1)
		waitDialogCounter--;
	else
	{
		waitDialogCounter--;
		jQuery('#overlay').stop().fadeOut(200);
	}	
}

function loadNavBar()
{
	jQuery('.nav li').hover(function() 
	{ //appearing on hover
        jQuery('ul', this).fadeIn();
	},
    function () { //disappearing on hover
        jQuery('ul', this).fadeOut();
    });
}

function loadButtons()
{
	jQuery(document).find(':button, input[type="submit"]').filter(".dialogButton").each(function()
	{
		jQuery(this).button();
	});
}

function moveDialogButtons(dialog)
{
	jQuery(dialog).parent().find('.ui-dialog-buttonset').find(':button, input[type="submit"]').filter(".dialogButton").remove();
	jQuery(dialog).find(':button, input[type="submit"]').filter(".dialogButton").prependTo(jQuery(dialog).parent().find('.ui-dialog-buttonset'));
	jQuery(dialog).parent().find('.ui-dialog-buttonset').find(':button, input[type="submit"]').filter(".dialogButton").each(function()
	{
		jQuery(this).button();
	});
}

function loadImages()
{
	jQuery('img.editButton:not(.buttonInitialised').each(function()
			{
				jQuery(this).attr({src: contextPath + "/resources/css/images/editButton.png", height: "16px", width: "16px"});
				jQuery(this).addClass('clickable');
				jQuery(this).addClass('buttonInitialised');
			});
}

function loadDateTimes()
{
	jQuery('input.datePicker:not(.dateInitialised').each(function()
	{
		var params = 
			{
				showOn: "both",
				buttonImage: "data:image/jpeg;base64,/9j/4QAYRXhpZgAASUkqAAgAAAAAAAAAAAAAAP/sABFEdWNreQABAAQAAABkAAD/4QMraHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLwA8P3hwYWNrZXQgYmVnaW49Iu+7vyIgaWQ9Ilc1TTBNcENlaGlIenJlU3pOVGN6a2M5ZCI/PiA8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIiB4OnhtcHRrPSJBZG9iZSBYTVAgQ29yZSA1LjAtYzA2MCA2MS4xMzQ3NzcsIDIwMTAvMDIvMTItMTc6MzI6MDAgICAgICAgICI+IDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+IDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiIHhtbG5zOnhtcD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLyIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bXA6Q3JlYXRvclRvb2w9IkFkb2JlIFBob3Rvc2hvcCBDUzUgTWFjaW50b3NoIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOjVBOTQ4NTQ3RDgxNTExREY5NkJGRDgyNjQ2OENCMzA5IiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOjVBOTQ4NTQ4RDgxNTExREY5NkJGRDgyNjQ2OENCMzA5Ij4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6NUE5NDg1NDVEODE1MTFERjk2QkZEODI2NDY4Q0IzMDkiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6NUE5NDg1NDZEODE1MTFERjk2QkZEODI2NDY4Q0IzMDkiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz7/7gAOQWRvYmUAZMAAAAAB/9sAhAABAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAgICAgICAgICAgIDAwMDAwMDAwMDAQEBAQEBAQIBAQICAgECAgMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwP/wAARCAAUABQDAREAAhEBAxEB/8QBogAAAAYCAwEAAAAAAAAAAAAABwgGBQQJAwoCAQALAQAABgMBAQEAAAAAAAAAAAAGBQQDBwIIAQkACgsQAAIBAwQBAwMCAwMDAgYJdQECAwQRBRIGIQcTIgAIMRRBMiMVCVFCFmEkMxdScYEYYpElQ6Gx8CY0cgoZwdE1J+FTNoLxkqJEVHNFRjdHYyhVVlcassLS4vJkg3SThGWjs8PT4yk4ZvN1Kjk6SElKWFlaZ2hpanZ3eHl6hYaHiImKlJWWl5iZmqSlpqeoqaq0tba3uLm6xMXGx8jJytTV1tfY2drk5ebn6Onq9PX29/j5+hEAAgEDAgQEAwUEBAQGBgVtAQIDEQQhEgUxBgAiE0FRBzJhFHEIQoEjkRVSoWIWMwmxJMHRQ3LwF+GCNCWSUxhjRPGisiY1GVQ2RWQnCnODk0Z0wtLi8lVldVY3hIWjs8PT4/MpGpSktMTU5PSVpbXF1eX1KEdXZjh2hpamtsbW5vZnd4eXp7fH1+f3SFhoeIiYqLjI2Oj4OUlZaXmJmam5ydnp+So6SlpqeoqaqrrK2ur6/9oADAMBAAIRAxEAPwDZ4x8vbPyA7s7O2tg+xM/hshtzP78NPRjsDfW0cFR7f2rvU7TpKalpNoS+N6t45oJGaSEliXJf6A+690t9z/G7v3ae2tw7qyXbeWlx22sHltwZCOj7t7qkq5KLDUFRkapKWOY08L1LwUzBA8iKWsCwHI917oLf9PfYX+y4W/vluHV/p2/uF/eH+L1395P7tf6NP76/afx3yfxTzfxb9rzeXz+HjXfn37r3QKbU3TPgu/fllDHuKswVbWP2FRbfON7W2r0rmKrJHv8A2TkamiwnYW8YKrCYmsOGo62aWJ4pXqqOKeFAGfWvuvdGC7d7pxkGH7Ijpuy564VtZ8oazE4+p+T+295bczm292YXZGxtmQUu09hbD3VV1FNUVW6p67bG2K6oxz4Y46uqKquMHkkg917omv31X/slv3vnf7r/AGaj/PenV/zKDxf00/5vj6e/de6Gz5J/7Jb/AKZN8fxX/Tj/AHj/AI7X/wB6f9H/APcv+7v94vMf4r4f70/5X5/u9fl8f7Xl1W59+690BP8AzhH/AOBUf+wk9+690ez/AJw2/wBk2/5jv/R1/fv/AKYv9If+kP7L/wA9H3/8I/6pftf8Pfuvdf/Z",
				buttonImageOnly: true,
				buttonText: "Select",
				dateFormat: "dd-M-y"
			};
		
		if (jQuery(this).attr('onchangeHandler'))
		{
			params.onSelect = function(dateText){dateHandler(dateText);};
		}
		
		jQuery(this).datepicker(params);
		
		jQuery(this).addClass('dateInitialised');
	});
}

function loadFieldsets()
{
	jQuery('fieldset:not(.fieldsetInitialised').each(function()
			{
				if (jQuery(this).attr("fieldsetWidth"))
				{
					var width = parseInt(jQuery(this).attr("fieldsetWidth"));
					jQuery(this).css({width: width});
				}							
				jQuery(this).addClass('fieldsetInitialised');
			});
}

function loadCalendars()
{
	jQuery('div.calendar:not(calendarInitialised').each(function()
			{
				var params = 
				{
					/*
					header option will define our calendar header.
					left define what will be at left position in calendar
					center define what will be at center position in calendar
					right define what will be at right position in calendar
					*/
					header:
					{
						left: 'prev,next',
						center: 'title',
						right: 'prev,next'
					},
					/*
						defaultView option used to define which view to show by default,
						for example we have used agendaWeek.
					*/
					defaultView: 'month',
					/*
						selectable:true will enable user to select datetime slot
						selectHelper will add helpers for selectable.
					*/
					selectable: false,
					selectHelper: false,
					timeFormat: ''				
				};
				
				jQuery(this).fullCalendar(params);
				
				jQuery(this).addClass('calendarInitialised');
			});
}

function fillSelectBoxFromUrl(url, selectElement)
{
	var ajax = ajaxRequest(url, 'json');
	
	ajax.done(function(jsonArray)
	{
		fillSelectBox(selectElement, jsonArray);
	});
	
	return ajax;
}

function fillSelectBox(selectElement, jsonArray)
{
	selectElement.find('option[value!="0"]').remove();
	
	jQuery.each(jsonArray, function(key, object)
	{
		selectElement.append(jQuery('<option/>', {value: object.id, text: object.name}));
	});
}

function destroyDialog(dialog)
{
	dialog.dialog("close");
}

function createDialog(url, title)
{
	showWaitingDialog();
	
	var loaded = jQuery.Deferred();
	var completed = jQuery.Deferred();
	
	var windowId = title.replace(/\s/g, "_");
	
	var content = null;
	
	if (url.search("\\?") > 0)
		url += "&decorator=none";
	else
		url += "?decorator=none";
	
	content = jQuery('<div id="' + windowId + '"></div>').load(url,
		function(response, status, xhr)
		{
			if (status == "error")
				throw new xhr.responseText;
			else
			{
				content.attr("loadUrl", url);
				
				var dialog = null;
				
				dialog = jQuery(this).dialog(
				{
					modal: true,
					title: title,
					width: "auto",
					maxWidth: "600px",
					overflow: "auto",
					
					open: function()
					{
						loaded.resolve();
					},
					close: function()
					{
						destroyDialog(dialog);
						completed.resolve();
					},
					buttons:
					{
						"Close": function()
						{
							destroyDialog(dialog);
							completed.resolve();
						}
					}
				});
				
				moveDialogButtons(dialog);
				closeWaitingDialog();
			}
		});
	
	return {'loaded': loaded, 'completed': completed};
}

function submitForm(form)
{
	jQuery(form).submit();
}

function ajaxRequest(url, dataType)
{
	showWaitingDialog();
	
	var completedDeferedObject = jQuery.ajax({
		type: HttpGet,
		url: url,
		dataType: dataType,
		processData: false,
		contentType: false,
		error: function(xhr)
		{
			closeWaitingDialog();
		},
		success: function()
		{
			closeWaitingDialog();
		}
	});
	
	return completedDeferedObject;
}

function ajaxSubmit(url, dataType, data, requestType)
{
	showWaitingDialog();
	
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");

    jQuery(document).ajaxSend(function(e, xhr, options) 
	{
        xhr.setRequestHeader(header, token);
    });
    
    var contentType = false;
    
    if (!requestType)
    	requestType = HttpPost;
    
    if (dataType === 'json')
	{
    	contentType = 'application/json';
	}
	
	var completedDeferedObject = jQuery.ajax({
		type: requestType,
		url: url,
		data: data,
		dataType: dataType,
		processData: false,
		contentType: contentType,
		error: function(xhr)
		{
			/*alertDialog(xhr.responseText, "Error");*/
			alertDialog(xhr.responseJSON.error, xhr.responseJSON.title);
			closeWaitingDialog();
		},
		success: function()
		{
			closeWaitingDialog();
		}
	});
	
	return completedDeferedObject;
}

function alertDialog(message, title)
{
	var defered = jQuery.Deferred();
	
	var dialog = null;
	
	dialog = jQuery('<div></div>').html(message).dialog(
		{
			modal: true,
			title: title,
			width: "35vw",
			maxWidth: "600px",
			overflow: "auto",
			close: function()
			{
				defered.resolve();
			},
			buttons:
			{
				"OK": function()
				{
					destroyDialog(dialog);
				}
			}
		});
	
	return defered;
}

function confirmDialog(message, title)
{
	var defered = jQuery.Deferred();
	
	var dialog = null;
	
	dialog = jQuery('<div></div>').html(message).dialog(
		{
			modal: true,
			title: title,
			width: "35vw",
			maxWidth: "600px",
			overflow: "auto",
			close: function()
			{
				destroyDialog(dialog);
			},
			buttons:
			{
				"OK": function()
				{					
					defered.resolve();
				},
				"No": function()
				{
					defered.reject();
				}
			}
		});
	
	return defered;
}

function refreshPage()
{
	window.location.reload(true);
}

function redirectTo(url)
{
	window.location.href = url;
}

function refreshDiv(div)
{
	var url = div.attr('loadUrl');
	
	var ajax = ajaxRequest(url, 'html');
	
	ajax.done(function(xhr)
	{
		div.html(xhr);
		moveDialogButtons(div);
	});
	
	div.attr('loadUrl', url);
}

function processFormToJsonViaAjax(formId)
{
	var form = jQuery('#' + formId);
	
	form.find("input[name='_csrf']").remove();
	
	return JSON.stringify(form2js(formId));
}

$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() 
	{
    	var name = this.name;
    	var val = this.value;
    	
    	if (name !== '_csrf')
		{
	        if (o[name] !== undefined) 
	        {
	            if (!o[name].push) 
	            {
	                o[name] = [o[name]];
	            }
	            o[name].push(val || '');
	        } 
	        else 
	        {
	            o[name] = val || '';
	        }
		}
    });
    return o;
};

function displayValueWithLink(value)
{
	if (value == null)
		value = "";
	
	if (value.length > 5 && value.substring(0, 4) == "http")
	{
		value = "<span class='clickable' onclick='loadUrlInNewTab(\"" + value + "\")'>" + value + "</span>";
	}
	
	return value;
}

function loadUrlInNewTab(url)
{
	window.open(url,'_blank');
}

function displayValue(value)
{
	if (value == null)
		value = "";
	
	return value;
}

function getQueryVariableInDialog(dialog, variable)
{
	var query = jQuery(dialog).attr('loadUrl').split("?");
	return splitQueryVariable(query[1], variable);
}

function splitQueryVariable(query, variable)
{
	var vars = query.split("&");
    for (var i=0;i<vars.length;i++) 
    {
        var pair = vars[i].split("=");
        if(pair[0] == variable)
        {
     	   return pair[1];
 	   }
    }
    return(false);
}

function getQueryVariable(variable)
{
   var query = window.location.search.substring(1);
   return splitQueryVariable(query, variable);       
}