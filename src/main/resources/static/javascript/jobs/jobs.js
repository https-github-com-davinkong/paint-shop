const jobTitle = document.getElementById("jobTitle").value;
const cliendId = document.getElementById("client").value;
const productId = document.getElementById("product").value;
const contractorId = document.getElementById("contractor").value;
const dueDate = document.getElementById("due-date").value;


const formSaveJob = document.getElementById("form-save-job");

const baseUrl = "http://localhost:8080/api/v1/jobs"

const header = {
    'Content-Type':'application/json'
}

formSaveJob.addEventListener('submit', async (e) => {
       e.preventDefault();
       const jobData = getFormValues();
       console.log(jobData);

       const response = await fetch("http://localhost:8080/api/v1/jobs/job", {
               method: "POST",
               body: JSON.stringify(jobData),
               headers: header
           })

           let responseArr = await response.json();
           console.log(responseArr);
           window.alert("Job added successfully")

           //clear the form inputs
           formSaveJob.reset();

})

function getFormValues() {
       const jobTitle = document.getElementById("jobTitle").value;
       const cliendId = document.getElementById("client").value;
       const productId = document.getElementById("product").value;
       const contractorId = document.getElementById("contractor").value;
       const dueDate = document.getElementById("due-date").value;

        const date = new Date(dueDate);
        const isoString = date.toISOString();
        const formattedDate = isoString.split("T")[0] + "T00:00:00Z";
        console.log(formattedDate);

        let selectClient = document.getElementById("client");
        let selectedClientOption = selectClient.options[selectClient.selectedIndex];
        let clientFirstName = selectedClientOption.getAttribute("data-first-name");
        let clientLastName = selectedClientOption.getAttribute("data-last-name");

        let selectContractor = document.getElementById("contractor");
        let selectedContractorOption = selectContractor.options[selectContractor.selectedIndex];
        let contractorFirstName = selectedContractorOption.getAttribute("data-first-name");
        let contractorLastName = selectedContractorOption.getAttribute("data-last-name");
        let contractorEmail = selectedContractorOption.getAttribute("data-email");
        let contractorIsAdmin = selectedContractorOption.getAttribute("data-isAdmin");

        let selectProduct = document.getElementById("product");
        let selectedProductOption = selectProduct.options[selectProduct.selectedIndex];
        let productPaintColor = selectedProductOption.getAttribute("data-paint-color");
        let productDescription = selectedProductOption.getAttribute("data-description");
        let productTools = selectedProductOption.getAttribute("data-tools");

        selectedContractorOption.disabled = true;
        selectedProductOption.disabled = true;

        const clientInformation = {
                                       id : cliendId,
                                       firstName : clientFirstName,
                                       lastName : clientLastName
                                       };

       const contractorInformation = {
                                      id : contractorId,
                                      firstName : contractorFirstName,
                                      lastName : contractorLastName,
                                      email : contractorEmail,
                                      isAdmin : contractorIsAdmin,
                                      jobAssigned : "true"
                                      };

       const productInformation = {
                                      id : productId,
                                      description : productDescription,
                                      paintColor : productPaintColor,
                                      tools : productTools,
                                      };

       const jobInformation = {
                                jobTitle : jobTitle,
                                date : formattedDate,
                                contractorsDto : contractorInformation,
                                productsDto : productInformation,
                                clientDto : clientInformation
                               };

       return jobInformation;
}
