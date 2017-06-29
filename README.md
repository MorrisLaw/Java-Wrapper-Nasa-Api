# Java-Wrapper-Nasa-Api

## Description
This is a Java wrapper for NASA's open API. 

**Note:** This Java API Wrapper has been developed and/or tested on Ubuntu 16.04 and macOS Sierra v10.12.3. I have not tested the instructions below on any other OS. Sorry for any inconvenience. 

## Installation

#### Install Dependencies.
Go to this [link](http://apache.mirror.colo-serv.net//httpcomponents/httpclient/binary/httpcomponents-client-4.5.3-bin.tar.gz) to install Apache HTTPComponents 4.5.3 binary tar.gz.

* macOS Sierra v10.12.3: 
Steps to importing this library into eclipse.
1. - When downloading this link, once it finishes use "Show in Finder" to find where it has downloaded onto your system. Double click the file to extract it. 
2. - Open up Java-Wrapper-Nasa-Api in eclipse. Then right click on Project and select "Add External Archives..."
3. - It should open the directory where your Apache jar files are, if it does not you'll need to navigate to their location.
4. - While holding down the shift button, select the jar files to be imported into eclipse.
5. - A popup dialog box will appear saying that its building the path. Then the jar files will appear in a folder named "Referenced Libraries" located in your Project folder.

* Ubuntu 16.04:

## Getting Started 
* ### API Key
In order to utilize or contribute to this API wrapper, you first need to retrieve an API key. Follow the instructions at this [link](https://api.nasa.gov/index.html#apply-for-an-api-key) get your API key. Once you have your API key, I recommend exporting it as an environment variable.

#### Recommended API Key storage options:

##### Option 1. Store as environment variable.

To permanently store your API key, open up a terminal window. Using the text editor of your choosing, open your ~/.bashrc file. Type the following, somewhere inside your ~/.bashrc file:

```export NASA_API_KEY=<your_nasa_key>``` 
Save the file. Then when back in the shell, source your ~/.bashrc file:

```source ~/.bashrc```

##### Option 2. Store in current shell session.

To temporarily store your API key in your current shell session, simply type into the terminal:

```export NASA_API_KEY=<your_nasa_key>```

## Usage
**~In Progress~**

## Contributing
#### Fork and Clone this Project.
* Use the fork button located at the top right of this page.
* then clone the repository, by typing the following into your terminal, into the directory of your choosing:
```git clone https://github.com/MorrisLaw/Java-Wrapper-Nasa-Api.git```

## Credits
Jeremy L. Morris, jeremylevanmorris@gmail.com
