# (solved) prettier extension not working in vscode

## Occured Error

- Pretter extension not working in vscode

## Solution

- Copy and paste in settings.json file (command + ','   ⇒ Extension → Edit in settings.json )

    ```json
    {
      "editor.defaultFormatter": "esbenp.prettier-vscode",
      "[javascript]": {
        "editor.defaultFormatter": "esbenp.prettier-vscode"
      }
    }
    ```

- Append this code!