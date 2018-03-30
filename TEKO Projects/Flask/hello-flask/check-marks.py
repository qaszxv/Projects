from flask import Flask, render_template

app = Flask(__name__)

@app.route('/mark/<int:score>')
def checkScore(score): 
    return render_template('marks.html', marks = score)

@app.route('/result')
def result(): 
    diction = {'phy': 80, 'bio': 90, 'math': 100}
    return render_template('results.html', result=diction)

if __name__ == '__main__': 
    app.run(debug=True)