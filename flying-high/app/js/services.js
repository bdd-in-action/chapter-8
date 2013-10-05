'use strict';

var services = angular.module('flyinghigh.services', []);

services.service('authentication', function () {
    var user;
    return {
        isAuthenticated: function () {
            return !!user;
        },
        authenticateWith: function (someUser) {
            user = someUser;
        },
        getUser : function() {
            return user;
        }
    };
});