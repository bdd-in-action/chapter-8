'use strict';

/* Controllers */

angular.module('flyinghigh.controllers', []).

    controller('LoginCtrl', function ($scope, $location, authentication) {
        var users = [{email: 'jane@acme.com', password:'s3cr3t', firstName:'Jane', lastName:'Smith'},
            {email: 'joe@acme.com',  password:'s3cr3t2', firstName:'Joe', lastName:'Blogs'}
        ];

        $scope.status = 'Gold';
        $scope.auth = function () {
            var user
            for(var i = 0; i < users.length; i++) {
                if ((users[i].email == $scope.email) && (users[i].password == $scope.password)) {
                    user = users[i];
                }
            }
            if (user) {
                authentication.authenticateWith(user);
                $location.url('/home');
                $scope.authenticationError = '';
            } else {
                $scope.authenticationError = 'Sorry, wrong username or password';
            }
        };
    })
    .controller('HomeCtrl',function ($scope, authentication) {
        $scope.user = authentication.getUser();
    });

