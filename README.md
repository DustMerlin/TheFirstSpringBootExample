# My first spring project

## src
    https://spring.io/guides
    
  
## tool
    https://github.com   
    http://git-scm.com/download
    https://help.github.com/en/github/authenticating-to-github/checking-for-existing-ssh-keys
    
## use git
### 创建本地仓库
#### git的最小配置
    设置用户名和邮箱
    git config --global user.name "your_name"
    git config --global user.email "your_email"
    //user.name "your_name" 这个之间没有等号，只为空格
    
    git config --local //
    git config --gloabl //
    git config --system //
    
    git config --local --list//
    git config --gloabl --list//
    git config --system --list//
    
    pwd
    
    alice.name = cmd
    
    //创建本地的git仓库
    
    cd 已有项目所在的文件夹
    git init
    
    cd 某个文件夹
    git init your_project
    cd your_project
    
    //为某个仓库设置,局部设置屏蔽全局设置
    git config --local user.name "your_name"       
    git config --local user.email "your_email"
    
    cp 被拷贝文件路径 拷贝文件路径
    
    git add 文件名 //将文件提交到缓存区，由git管理
    git add -u //git 管理的全部提交到暂存区
    git rm  文件名//删除文件
    git commit -m"提交理由（可省略）" 
    
    //工作目录-git add files>暂存区-git commit> 历史版本
    
    git status //git的管理状态
    
    //rename example readme -> readme.md
    git mv readme readme.md//√
    
    mv readme readme.md//×
    git add readme.md
    git rm readme
    
    git reset --hard //清理掉工作路径和暂存区中的内容
    
    git log
    git log --oneline
    git log --n4 //最近的四次提交
    git log //查看当前分支
    git checkout -b temp 提交文件可识别的哈希值//创建分支
    git log --all
    git log --all --graph
    
    git log --oneline --all -n4 --graph
        
    git branch -av //查看git分支
    gitk //打开图形界面
    
#### 探索.git 目录 
    git cat-file -t 哈希值//查看类型 commit tree blob
    git cat-file -p 哈希值//查看内容
    HEAD 所在的分支
    config 配置信息
    refs 应用和tags
    objects 对象
    
 > 文件内容相同即为相同的blob 
    
 ### git对象的存储关系
    commit:一个commit对应一颗树，为所有文件的快照
        tree
        parent
        author
        committter    
        
    tree：可以看做为文件夹，文件夹也为树
        tree 
        blob:tree 中包含 blob
        
    blob：具体的文件；文件内容相同，blob只有一个，与文件名无关
    
    find .git/objects -type -f
    FIND: 参数格式不正确

> 分离头指针：要做变更就要与某个分支（branch）挂钩，否则不安全
> 12分离头指针的情况下的注意事项

    工作在没有分支的情况下，git对commit产生变更，切换分支后，commit没有对应的branch和他挂钩，
    这些变更可能会被git当做垃圾清除掉
    尝试性的变更，可以不用挂钩branch，不需要就切换分支，丢掉不用的
    
    git checkout -b 分支名 分支来源  // 可以创建分支，切换分支
    
    git diff commit_1 commit_2 //比较commit_1 和commit_2 的差异
    git diff HEAD HEAD~1(^1)[/HEAD~2(^^)]
    
    git branch -d 分支名 // 删除分支
    git branch -D 分支名 // 
    
    git branch -av
   
    

   

    
        
    
    
    
    
    
    
    
   
    
    
    
    
    
    生成SSH公钥和秘钥，方便通过git提交到github的仓库中
    
