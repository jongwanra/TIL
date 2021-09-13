# How to upload image file

1. add bootstrap html code

    ```html
    <div class="custom-file">
      <input type="file" class="custom-file-input" id="customFile">
      <label class="custom-file-label" for="customFile">Choose file</label>
    </div>
    ```

1. add file upload library

    ```html
    <script src="https://cdn.jsdelivr.net/npm/bs-custom-file-input/dist/bs-custom-file-input.js"></script>
    ```

1. add file upload code after loading

    ```jsx
    $(document).ready(function () {
                bsCustomFileInput.init();
    						//.
    						//.
    						//.
            })
    ```

1. server side receive code

    ```python
    file = request.files["file_give"]

    save_to = 'static/mypicture.jpg'
    file.save(save_to)
    ```

1. client side send code

    ```jsx
    function posting() {
        let title = $('#title').val()
        let content = $("#content").val()

        let file = $('#file')[0].files[0]
        let form_data = new FormData()

        form_data.append("file_give", file)
        form_data.append("title_give", title)
        form_data.append("content_give", content)

        $.ajax({
            type: "POST",
            url: "/diary",
            data: form_data,
            cache: false,
            contentType: false,
            processData: false,
            success: function (response) {
                alert(response["msg"])
                window.location.reload()
            }
        });
    }
    ```