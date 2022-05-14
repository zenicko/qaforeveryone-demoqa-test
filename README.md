# The first project uses TestNG, Selenium and Owner

## Acknowledgment

## How to use

## What's new
1. Git. Delete a wrong commit from the local and the remote repositories
```
<f6c1d11> (HEAD -> master, original/master) Added the solve of 4.5.4 The symmetric matrix
c80276a Added choosing field Date of birth
823ea83 Fixed selector Gender
ac67833 Deleted unuseable statements iter1
```
   `git reset --hard c80276a`
```
f6c1d11 (original/master) Added the solve of 4.5.4 The symmetric matrix
c80276a (HEAD -> master) Added choosing field Date of birth
823ea83 Fixed selector Gender
ac67833 Deleted unuseable statements iter1
```
   `git push --force original master`

2. Devtools. Freeze screen in chrome debugger / DevTools panel for popover inspection? [3,4]
   1. Open DevTools (F12)
   2. Open Console and start the script
      `setTimeout(function(){debugger;}, 5000)`
      You have five seconds to choose the element in DOM.
3. Selenium. Upload a file [5,6].
```
// assuming driver is a healthy WebDriver instance
WebElement fileInput = driver.findElement(By.name("uploadfile"));
fileInput.sendKeys("C:/path/to/file.jpg");
```

4. How to get the name of a file from the full path? [7]
`NAME_OF_FILE = new File(PATH_TO_FILE).getName();`

## Resources
1. [The site demoqa.com](https://demoqa.com/)
2. [AssertJ - fluent assertions java library](https://assertj.github.io/doc/)
3. [Devtools. How to freeze script?](https://qastack.ru/programming/17931571/freeze-screen-in-chrome-debugger-devtools-panel-for-popover-inspection)
4. [Freeze screen in chrome debugger / DevTools panel for popover inspection?](https://stackoverflow.com/questions/17931571/freeze-screen-in-chrome-debugger-devtools-panel-for-popover-inspection/23096743#23096743)
5. [How to Upload a File Using Selenium?](https://www.browserstack.com/guide/file-upload-in-selenium)
6. [How to handle windows file upload using Selenium WebDriver?](https://stackoverflow.com/questions/11256732/how-to-handle-windows-file-upload-using-selenium-webdriver)
7. [Get the name of a file by Java.io.File.getName()](https://www.tutorialspoint.com/java/io/file_getname.htm)

## Miscellaneous
