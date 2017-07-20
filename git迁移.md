### git repo迁移：
如果想要切换git托管，就是将之前git提交托管切换到新的git托管，能够保存之前完整的git版本历史。
（1）首先，需要创建远程新的git托管路径：
```shell
https://github.com/hellmonky/JOJO.git
```
（2）然后，将当前要进行迁移的工程，获取bare版本：
```shell
git clone --bare http://admin@localhost:10101/r/JOJO.git
```
（3）最后，进入这个bare版本，推送到新的托管路径：
```shell
cd  JOJO.git
git push --mirror https://github.com/hellmonky/JOJO.git
```
这样就可以完整的保存了。