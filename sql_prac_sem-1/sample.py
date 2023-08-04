        ##LL-case
        if bal>1 and self.getBalance(root.left)>=0:
            return self.rightRotate(root)
        ##RR-case
        if bal<-1 and self.getBalance(root.right)<=0:
            return self.leftRotate(root)
        ##RL-case
        if bal<-1 and self.getBalance(root.right)>0:
            root.right = self.rightRotate(root.right)
            return self.leftRotate(root)
        ##LR-case
        if bal>1 and self.getBalance(root.left)<0:
            root.left = self.leftRotate(root.left)
            return self.rightRotate(root)
