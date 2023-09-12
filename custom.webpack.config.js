var merge = require('webpack-merge').merge;
var generated = require('./scalajs.webpack.config');

var local = {
    module: {
        rules: [
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader']
            },
            {
                test: /\.(ttf|eot|woff|png|glb|svg|md|ts)$/,
                use: 'asset/resource'
            },
            {
                test: /\.(eot)$/,
                use: [
                    {
                        loader: 'url-loader',
                        options: {
                            limit: 8192,
                        }
                    },
                ],
                type: 'javascript/auto'
            }
        ]
    }
};

module.exports = merge(generated, local);
