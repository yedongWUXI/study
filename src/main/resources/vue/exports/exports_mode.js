var sayHello = function () {
    console.log('hello')
}
exports.sayHello = sayHello
console.log(exports);
console.log(module.exports);