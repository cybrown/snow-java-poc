#! /bin/bash
rm docFromTestCase.md
find ./test_files/* -type d | while read folderPath
do
    name=$(basename "$folderPath")
    echo $'#'"$name" >> docFromTestCase.md
    find ./"$folderPath" -type f -name "*.txt" | while read filePath
    do
      nameFile=$(basename "${filePath%.*}")
      echo $'* ###'$nameFile >> docFromTestCase.md
      echo  $'\n\t*Example:* \n\n\t\t' $(awk '{printf $0}' $filePath) $'\n' >> docFromTestCase.md
    done
done
echo "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>" > docFromTestCase.html
curl --data-binary @docFromTestCase.md -H "Content-Type:text/plain" -s https://api.github.com/markdown/raw >> docFromTestCase.html