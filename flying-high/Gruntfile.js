module.exports = function(grunt) {

    grunt.loadNpmTasks('grunt-bower-task');

    grunt.initConfig({

        //Run 'grunt bower:install' to install the libraries in the app/lib directory
        bower: {
            install: {
                options: {
                    targetDir: "app/lib"
                }
            }
        }
    });
};