
const API_BOOK = "http://localhost:8080/api/books"

function renderBook(){
    $.ajax({
        url : API_BOOK,
        method : "GET"
    }).done(data => {
        let str = '';
        data.forEach(book =>{
            str += `<tr>
    <th>${book.id}</th>
    <td>${book.title}</td>
    <td>${book.description}</td>
    <td>${book.publishDate}</td>
    <td>${book.price}</td>
    <td>${book.author.authorName}</td>
    <td>${book.category.categoryName}</td>
    <td>${book.type}</td>
    <td>
      <button type="button" class="btn btn-outline-success" onclick="showUpdate(${book.id})" data-bs-toggle="modal" data-bs-target="#modalUpdate">
        <i class="fas fa-user-edit"></i>
      </button>
    </td>
    <td>
      <button type="button" class="btn btn-outline-primary" onclick="showDeposit(${book.id})" data-bs-toggle="modal" data-bs-target="#modalPlus">
        <i class="fas fa-plus"></i>
      </button>
    </td>
    <td>
      <button type="button" class="btn btn-outline-danger" onclick="deleteBook(${book.id})">
        <i class="fa-solid fa-trash"></i>
      </button>
    </td>
  </tr> `
        })
        document.getElementById("book").innerHTML = str;
        console.log(data)
    }).fail(error =>{

    })
}
renderBook();


function createAuthor(){
    $.ajax({
        url : "http://localhost:8080/api/authors",
        method : "GET"
    }).done(data => {
        let str = ''
        data.forEach(author => {
            str += `<option value="${author.id}">${author.authorName}</option>`
        })
        document.getElementById("author").innerHTML = str ;
        document.getElementById("authorUp").innerHTML = str ;
    })
}
createAuthor();

function createCategory(){
    $.ajax({
        url : "http://localhost:8080/api/categories",
        method : "GET"
    }).done(data => {
        let str = ''
        data.forEach(category => {
            str += `<option value="${category.id}">${category.categoryName}</option>`
        })
        document.getElementById("category").innerHTML = str ;
        document.getElementById("categoryUp").innerHTML = str ;
    })
}
createCategory();

function create(){
  let  book = {
      title : document.getElementById("title").value,
      description : document.getElementById("description").value,
      publishDate : document.getElementById("date").value,
      price : document.getElementById("price").value,
      category : {
          id : document.getElementById("category").value,
          categoryName : document.getElementById("category")
              .options[document.getElementById("category").selectedIndex].text
      },
      author : {
          id : document.getElementById("author").value,
          authorName : document.getElementById("author")
              .options[document.getElementById("author").selectedIndex].text
      },
      type : document.getElementById("type").value
    }

    $.ajax({
        url: API_BOOK,
        method: "POST",
        headers: {
            'accept': 'application/json',
            'content-type' : 'application/json'
        },
        data : JSON.stringify(book)
    }).done(data =>{
        console.log(data)
        document.getElementById("formCreate").reset();
        document.getElementById("closeCreate").click();
        renderBook();
    })
}

function deleteBook(id){
    $.ajax({
        url : API_BOOK + "/" + id,
        method : "DELETE"
    }).done(data =>{
        renderBook();
    })
}

function showUpdate(id){
    $.ajax({
        url : API_BOOK + "/" + id,
        method : "GET"
    }).done(data => {
        console.log(data)

        document.getElementById("titleUp").value = data.title;
        document.getElementById("descriptionUp").value = data.description;
        document.getElementById("priceUp").value = data.price;
        document.getElementById("dateUp").value = data.publishDate;
        document.getElementById("authorUp").value = data.author.id;
        console.log(data.author.id)
        document.getElementById("categoryUp").value = data.category.id;
        document.getElementById("typeUp").value = data.type;
        document.getElementById("btnUpdate").onclick = function (){
            update(data.id);
        }
    })
}

function update(id){
    let  bookUp = {
        title : document.getElementById("typeUp").value,
        description : document.getElementById("descriptionUp").value,
        publishDate : document.getElementById("dateUp").value,
        price : document.getElementById("priceUp").value,
        category : {
            id : document.getElementById("categoryUp").value,
            categoryName : document.getElementById("categoryUp")
                .options[document.getElementById("categoryUp").selectedIndex].text
        },
        author : {
            id : document.getElementById("authorUp").value,
            authorName : document.getElementById("authorUp")
                .options[document.getElementById("authorUp").selectedIndex].text
        },
        type : document.getElementById("type").value
    }

    $.ajax({
        url : API_BOOK + "/" + id,
        method : "PUT",
        headers: {
            'accept': 'application/json',
            'content-type' : 'application/json'
        },
        data: JSON.stringify(bookUp)
    }).done(book =>{
        console.log(book)
        document.getElementById("formUpdate").reset();
        document.getElementById("closeUpdate").click();
        renderBook();
    })
}