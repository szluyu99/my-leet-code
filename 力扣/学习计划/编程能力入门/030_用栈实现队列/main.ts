class MyQueue {
    inStack: number[]
    outStack: number[]
    constructor() {
        this.inStack = []
        this.outStack = []
    }

    push(x: number) {
        this.inStack.push(x)
    }

    pop(): number {
        if (!this.outStack.length) {
            while (this.inStack.length) {
                this.outStack.push(this.inStack.pop())
            }
        }
        return this.outStack.pop()
    }

    peek(): number {
        if (!this.outStack.length) {
            while (this.inStack.length) {
                this.outStack.push(this.inStack.pop())
            }
        }
        return this.outStack[this.outStack.length - 1]
    }

    empty(): boolean {
        return !this.inStack.length && !this.outStack.length
    }
}