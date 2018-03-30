from flask import Flask, url_for, redirect

app = Flask(__name__)

@app.route('/admin')
def helloadmin(): 
    return 'Hello Admin'

@app.route('/guest/<guest>')
def helloguest(guest): 
    return 'Hello %s:' % guest

@app.route('/user/<user>')
def getUser(user): 
    if (user == 'admin'): 
        return redirect(url_for('helloadmin'))
    else: 
        return redirect(url_for('helloguest', guest = user))

if __name__ == '__main__': 
    app.run()