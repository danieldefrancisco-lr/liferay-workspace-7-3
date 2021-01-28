<%@ include file="../init.jsp"%>

<div class="address-fields">
	<portlet:actionURL name="addApprovalAddData"
		var="addApprovalAddDataActionUrl" />

	<div class="form-group-autofit">
		<div class="col-md-2">
		<aui:input name="phoneNumber" label="Telephone Number" >
				<aui:validator name="required" />
			</aui:input>
		</div>
		<div class="col-md-2">
		<aui:select name="Previous Company" label="Previous Company" >
    		<aui:option value="Telekom Slovenije">Telekom Slovenije</aui:option>
    		<aui:option value="Telemach mob">Telemach mob</aui:option>
   			<aui:option value="T-2">T-2</aui:option>
</aui:select>
		</div>	
		<aui:input type="text" data-format="dd/MM/yyyy"
			name="genericDateField" class="aui-datepicker" id="datepicker"
			label="Select Date of Service" wrapperCssClass="form-group-item">
			<aui:validator name="required" />
			<aui:validator name="date" />

		</aui:input>
		
		<aui:input type="text"
			name="genericTimeField" class="aui-datepicker" id="timepicker"
			label="Select Time of Service" wrapperCssClass="form-group-item">
			<aui:validator name="required" />

		</aui:input>

	</div>

	<aui:script>
		AUI().use('aui-datepicker', function(A) {
			var datepicker = new A.DatePicker({
				trigger : '#<portlet:namespace />datepicker',
				mask: '%m/%d/%Y',
				calendar: {
                    dateFormat: '%m/%d/%Y',
                },
				popover : {
					zIndex : 1
				}
			});
		});


		AUI().use('aui-timepicker', function(A) {
			var datepicker = new A.TimePicker({
				trigger : '#<portlet:namespace />timepicker',
				popover : {
					zIndex : 1
				}
			});
		});		
		
	</aui:script>

</div>
