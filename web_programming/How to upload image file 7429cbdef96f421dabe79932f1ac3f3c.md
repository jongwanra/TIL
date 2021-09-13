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