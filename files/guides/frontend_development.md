# This guide should help you get a basic understanding of AngularJS

##AngularJS overview
AngularJS is a javascript framework that can help us dynamically control the elements inside an html page. It employs an MVC (model, view, controller) system.

I will explain how each part of a page works and how to develop a page. To begin, we will develop a "testpage.html" and add a controller and services to it and place it in our application.

Initially, you need to add routing to the page to app.js. It will look something like this:

```
.state('testpage', {
  url: '/testpage',
  templateUrl: 'views/testpage.html',
  controller: 'TestPageCtrl',
  resolve: {
    loadMyFiles: function($ocLazyLoad) {
      return $ocLazyLoad.load({
        files: [
          'scripts/controllers/TestPageController.js',
          'scripts/services/TestPageServices.js'
          'styles/TestPage.css'
        ]
      });
    }
  }
})
```

In app.js these are chained together, so adding this into the middle shouldn't cause any errors. The setup is pretty straight forward. url designates the path that must be requested for the page to load. templateUrl designates the html file that will be used as a template for loading your page. controller designates the controller that will be supplying data to your page.
resolve tells the app what files need to be loaded when rendering this webpage.
We use $ocLazyLoad to load in files only when a particular page is requested (this is lazy loading) because it lightens the initial loading burden. If we loaded the entire site when the homepage was opened, it would take much longer.


When developing an angular webapp, each individual page does not need all of the boilerplate html code that normal html needs. All that needs to be defined is a div that will hold everything that you want in your page. A simple page with only a header would look like this:

```
<div class = "testpage">
  <h3> This is a test page </h3>
</div>
```

What is nice about angular is that you can control what is displayed in your html with what are called directives.
Directives are just html markers that let angular know that you want to give some sort of functionality to the html you're marking. One of the simplest directives is ###ng-if. Say you wanted a div to only appear when a boolean ###isComplete is true. In order to do that you simply would have to write something like this:

```
<div class="testpage">
  <h3> This is a test page </h3>
  <div ng-if="isComplete"> Yay! We created a page! </div>
</div>
```

It's as simple as that! Angular has a lot of directives that are very useful so generally the AngularJS API and google can help you find a directive that will help you accomplish your task. You can always look at the HTML in this project for examples of how to use directives.

You can use CSS to style your page. Create a css file for your page specifically. In this situation it would be something like: testpage.css where we would put the styling for all the classes in the page. It will be linked to

These directives won't do anything unless there is a controller supplying values to them. This is where you will have to write a little javascript that will act as the controller of the html view that you have created. When you are creating a webapp with Angular, to start you will have named your app in app.js (app.js usually the script that handles all the routing of the application and piecing all the scripts and html together). Here in HireU we have our app named HireUApp. If I wanted to create a controller for my new page it would look something like this:


```
angular.module('HireUApp')
.controller('TestPageCtrl', function(){

});
```


Here we are creating a controller for our HireUApp. Each page we create will have its own scope. This is similar to how scopes work in normal programming.
The variables defined in the scope of your controller, will only have those values within the scope of your page.

So if we wanted to give isComplete a value then we can assign it in the the controller. Angular uses the same $scope that all javascript uses, you just have to specify it in the function parameters.


```
angular.module('HireUApp')
.controller('TestPageCtrl', function($scope){
  $scope.isComplete = true;
});
```


Not only can you define variables in the scope from the controller, you can also use data received from services to put inside the html.
Say that we actually wanted to retrieve the boolean value from some REST service endpoint that we have implemented. We would create our own services like this:


```
angular.module('HireUApp')
.service('TestPageService', function($q, $http) {
  this.getBoolean = function() {
    $http({
      url : 'localhost:8080/services/testpage'
      method : 'GET'
    }).success(function(data) {
      deferred.resolve({ status :'SUCCESS',
        message : 'Success in GET campus info',
        data : data
      });
    }).error(function(error) {
      deferred.reject({ status : 'ERROR',
        message : 'Error with GET campus info',
        data : error
      });
    });

    return deferred.promise;
  }

});
```


An explanation of what is going on in each part of the service definition:


```
angular.module('HireUApp')
.service('TestPageService', function($q, $http) {
  -- This is the function definition to get the boolean with an ajax call
  this.getBoolean = function() {
    -- This is what's called a promise. Since ajax calls are whats called asynchronous, meaning they execute separate from the main thread, there's no guarantee that the result thats returned has a value. This is why we return what's called a promise, which says 'Eventually this will have a value'
    -- We create the promise here

    var deferred = $q.defer();

    -- This is an ajax call, it will go to the url specified and get the data that is returned to it.
    -- This url is usually configured with a config script
    -- We have a config script that can be used in HireU
    -- Using it will be explained later

    $http({
      url : 'localhost:8080/services/testpage'
      method : 'GET'
    }).success(function(data) {
      deferred.resolve({ status :'SUCCESS',
        message : 'Success in GET test info',
        -- This is the data that the ajax call received from the endpoint that
        -- you want to return
        data : data
      });
    }).error(function(error) {
      deferred.reject({ status : 'ERROR',
        message : 'Error with GET test info',
        data : error
      });
    });

    -- If we get a result from the ajax call (either success or error), we make the promise resolve to a value.

    -- Here we are returning the promise which will likely happen before the ajax call has resolved.

    return deferred.promise;
  }

});
```



In order to make ajax calls less cumbersome, we have created a config script that is effectively a giant JSON to store values like url paths for us. You can use the script by adding it to the parameters of the function. If we wanted to use the config to get our endpoint URL then we the service would look something like this:


```
angular.module('HireUApp')
.service('TestPageService', function($q, $http, CONFIG) {
  this.getBoolean = function() {
    $http({
      url : CONFIG.url.appURL + CONFIG.url.services.testpage,
      method : 'GET'
    }).success(function(data) {
      deferred.resolve({ status :'SUCCESS',
        message : 'Success in GET test info',
        data : data
      });
    }).error(function(error) {
      deferred.reject({ status : 'ERROR',
        message : 'Error with GET test info',
        data : error
      });
    });

    return deferred.promise;
  }

});
```



The config script would look like this:


```
angular.module('hireUApp')
.value('CONFIG', {
  url : {
    appURL : 'http://localhost:8080/services',
    services : {
      testpage : 'testpage'
    }
  }
});
```



## Development practices

Initially you will want to create the html of the page. It's generally a good idea to try to write the html with a static controller before adding the services. So if you want to display a particular value, just hard code the value into the controller until the html is finished. This way you know things are displaying properly and you avoid having controller/service issues mess with your html.

Once you know what information you will need to display get someone to create endpoints for you and add them to the CONFIG json.

Generally we want to separate logical operations and data retrieval, which is the purpose of having services. Your services should only ever retrieve data and return a promise. It is up to your controller to figure out what it wants to do with the values that it is receiving. It is ok to clean up the data youre returning in services, for example if the REST service returns a JSON full of data but youre only concerned about some field X in the data instead of assigning data just the whole data object you can write something like:


```
.success(function(data) {
  deferred.resolve({ status :'SUCCESS',
    message : 'Success in GET test info',
    data : data.X
  });
})
```


This will return the value of X instead of the whole response that you got from the endpoint.
